package com.jhairdev.ui_threads;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

public class Serpiente extends Thread {

    private boolean estaViva;
    private GeneradorDeManzanas generadorDeManzanas;
    private Cronometro cronometro;
    private List<int[]> cuerpo;
    private int[] cola;
    private final int width;
    private final int height;
    private final double velocidad;
    private DialogPuntuacion dialogPuntuacion;

    private final String sonidoComerPath = "C:\\Users\\Jhair\\Documents\\NetBeansProjects\\app_pp_snake\\src\\main\\resources\\recursos\\sound\\comer.mp3";

    public Serpiente(int width, int height, int velocidad) {
        this.width = width;
        this.height = height;
        this.velocidad = velocidad;
        init();
    }

    @Override
    public void run() {
        try {
            cronometro.start();
            generadorDeManzanas.start();

            while (estaViva) {
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

                System.out.println("Posicion de la serpiente: (" + x + ", " + y + ")");

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

    private void reiniciar() {
        cronometro.pararCronometro();
        generadorDeManzanas.pararDeGenerar();
        if (estaViva) {
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
        generadorDeManzanas = new GeneradorDeManzanas(this.width, this.height);
        cronometro = new Cronometro();
        dialogPuntuacion = new DialogPuntuacion(FormMain.getFrames()[0], true);
    }

    public List<int[]> getCuerpo() {
        return cuerpo;
    }

    public void morir() {
        cronometro.pararCronometro();
        generadorDeManzanas.pararDeGenerar();

        System.out.println("Serpiente: La serpiente ha muerto");
        dialogPuntuacion.iniciar();
        dialogPuntuacion.setVisible(true);
        estaViva = false;
    }
}
