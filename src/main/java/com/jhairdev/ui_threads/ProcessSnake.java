package com.jhairdev.ui_threads;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

public class ProcessSnake extends Thread {

    private boolean estaViva;
    private ProcessApple generadorDeManzanas;
    private ProcessChronometer cronometro;
    private List<int[]> cuerpo;
    private int[] cola;
    private final int width;
    private final int height;
    private final double velocidad;
    private ScoreDialog dialogPuntuacion;

    private final String sonidoComerPath = "C:\\Users\\Jhair\\Documents\\NetBeansProjects\\app_pp_snake\\src\\main\\resources\\resources\\sound\\comer.mp3";
    private final String sonidoChocarPath = "C:\\Users\\Jhair\\Documents\\NetBeansProjects\\app_pp_snake\\src\\main\\resources\\resources\\sound\\pared.mp3";

    public ProcessSnake(int width, int height, int velocidad) {
        this.width = width;
        this.height = height;
        this.velocidad = velocidad;
        init();
    }

    @Override
    public void run() {
        try {
            System.out.println("" + velocidad);
            generadorDeManzanas.start();
            while (this.estaViva) {
                Point mousePos = MouseInfo.getPointerInfo().getLocation();
                SwingUtilities.convertPointFromScreen(mousePos, FormMain.tablero[0][0].getParent());

                Rectangle bounds = FormMain.tablero[0][0].getBounds();
                int mouseX = mousePos.x / bounds.width;
                int mouseY = mousePos.y / bounds.height;

                int x = this.cuerpo.get(0)[0];
                int y = this.cuerpo.get(0)[1];

                int dx = Integer.compare(mouseX, x);
                int dy = Integer.compare(mouseY, y);

                this.cola = this.cuerpo.get(ultimoSegmento()).clone();

                for (int i = ultimoSegmento(); i >= 0; i--) {
                    int[] segmento = this.cuerpo.get(i);
                    if (i == 0) {
                        segmento[0] += dx;
                        segmento[1] += dy;
                    } else {
                        this.cuerpo.get(i)[0] = this.cuerpo.get(i - 1)[0];
                        this.cuerpo.get(i)[1] = this.cuerpo.get(i - 1)[1];
                    }
                }

                if (FormMain.tablero[this.cuerpo.get(0)[0]][this.cuerpo.get(0)[1]].getBackground() == Color.RED) {
                    añadirCuerpo();
                } else {
                    FormMain.tablero[this.cola[0]][this.cola[1]].setBackground(Color.WHITE);
                }
                FormMain.tablero[this.cuerpo.get(0)[0]][this.cuerpo.get(0)[1]].setBackground(Color.BLACK);

                try {
                    Thread.sleep((long) velocidad);
                } catch (InterruptedException ex) {
                    System.out.println("Serpiente: Interrupción - Hilo parado");
                    break; // Salir del bucle si el hilo es interrumpido
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error admitido: " + e.getMessage());
        } finally {
            reiniciar();
        }
    }

    private int ultimoSegmento() {
        return this.cuerpo.size() - 1;
    }

    private void añadirCuerpo() {
        reproducirSonidoComer();
        this.cuerpo.add(this.cola.clone());
        generadorDeManzanas.manzanaDevorada();
        System.out.println("Serpiente: Manzana devorada");
    }

    private void reproducirSonidoComer() {
        new Thread(() -> {
            try {
                FileInputStream fis = new FileInputStream(sonidoComerPath);
                Player player = new Player(fis);
                player.play();
            } catch (JavaLayerException | IOException e) {
            }
        }).start();
    }

    private void reproducirSonidoChocar() {
        new Thread(() -> {
            try {
                FileInputStream fis = new FileInputStream(sonidoChocarPath);
                Player player = new Player(fis);
                player.play();
            } catch (JavaLayerException | IOException e) {
            }
        }).start();
    }

    private void reiniciar() {
        generadorDeManzanas.pararDeGenerar();
        if (estaViva) {
            reproducirSonidoChocar();
            FormMain.contadorMuertes++;
            FormMain.lblMuertesDato.setText(String.valueOf(FormMain.contadorMuertes));
            System.out.println("Serpiente muerta. Contador de muertes: " + FormMain.contadorMuertes);
        }

        limpiarTablero();
        init();
        estaViva = true;
        run();
    }

    private void limpiarTablero() {
        for (int i = 0; i < FormMain.tablero.length; i++) {
            for (int j = 0; j < FormMain.tablero[i].length; j++) {
                FormMain.tablero[i][j].setBackground(Color.WHITE);
            }
        }
    }

    private void init() {
        this.cuerpo = new ArrayList<>();
        FormMain.tablero[this.width / 2][this.height / 2].setBackground(Color.BLACK);
        this.cuerpo.add(new int[]{this.width / 2, this.height / 2, 0});
        this.cola = this.cuerpo.get(ultimoSegmento()).clone();
        generadorDeManzanas = new ProcessApple(this.width, this.height);
        dialogPuntuacion = new ScoreDialog(FormMain.getFrames()[0], true);
    }

    public List<int[]> getCuerpo() {
        return cuerpo;
    }

    public void morir() {
        generadorDeManzanas.pararDeGenerar();
        centrarMouse();
        dialogPuntuacion.iniciar();
        dialogPuntuacion.setVisible(true);
        this.estaViva = false;
        this.interrupt(); // Interrumpir el hilo
        System.out.println("Serpiente: La serpiente ha muerto");
    }

    private void centrarMouse() {
        try {
            Robot robot = new Robot();
            // Calcular el centro de la pantalla
            Point centro = new Point(this.width / 2, this.height / 2);
            SwingUtilities.convertPointToScreen(centro, FormMain.tablero[0][0].getParent());
            robot.mouseMove(centro.x, centro.y);
        } catch (AWTException e) {
            System.err.println("Error al centrar el mouse: " + e.getMessage());
        }
    }
}
