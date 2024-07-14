package com.jhairdev.ui_threads;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Serpiente extends Thread {
    private boolean estaViva;
    
    private GeneradorDeManzanas generadorDeManzanas;
    private Cronometro cronometro;

    private List<int[]> cuerpo;
    private int[] cola;

    private final int width;
    private final int height;
    
    private double velocidad;
    private DialogPuntuacion dialogPuntuacion;

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
                this.cola = this.cuerpo.get(ultimoSegmento()).clone();
                // Mueve el cuerpo
                for (int i = ultimoSegmento(); i >= 0; i--) {
                    switch (this.cuerpo.get(i)[2]) {
                        case KeyEvent.VK_A: 
                        case KeyEvent.VK_LEFT:
                            this.cuerpo.get(i)[0]--;
                            break;
                        case KeyEvent.VK_D: 
                        case KeyEvent.VK_RIGHT:
                            this.cuerpo.get(i)[0]++;
                            break;
                        case KeyEvent.VK_W: 
                        case KeyEvent.VK_UP:
                            this.cuerpo.get(i)[1]--;
                            break;
                        case KeyEvent.VK_S: 
                        case KeyEvent.VK_DOWN:
                            this.cuerpo.get(i)[1]++;
                            break;
                    }
                    if (i > 0) {
                        this.cuerpo.get(i)[2] = this.cuerpo.get(i - 1)[2];
                    }
                }
               
                if (FormMain.tablero[this.cuerpo.get(0)[0]][this.cuerpo.get(0)[1]].getBackground() == Color.RED) {
                    añadirCuerpo();
                } else if (FormMain.tablero[this.cuerpo.get(0)[0]][this.cuerpo.get(0)[1]].getBackground() == Color.BLUE) {
                    FormMain.tablero[this.cola[0]][this.cola[1]].setBackground(Color.WHITE);
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
        } finally {
            morir();
        }
    }

    private int ultimoSegmento() {
        return this.cuerpo.size() - 1;
    }

    public void setDireccion(int direccion) {
        this.cuerpo.get(0)[2] = direccion;
    }

    private void añadirCuerpo() {
        this.cuerpo.add(this.cola.clone());
        generadorDeManzanas.manzanaDevorada();
        System.out.println("Serpiente: Manzana devorada");
    }

    private void morir() {
        cronometro.pararCronometro();
        generadorDeManzanas.pararDeGenerar();
        System.out.println("Serpiente: La serpiente ha muerto");
        dialogPuntuacion.iniciar();
        dialogPuntuacion.setVisible(true);
        this.estaViva = false;
    }

    private void init() {
        this.estaViva = true;
        this.cuerpo = new ArrayList<>();
        FormMain.tablero[this.width / 2][this.height / 2].setBackground(Color.BLACK);
        this.cuerpo.add(new int[]{this.width / 2, this.height / 2, KeyEvent.VK_W});  
        this.cola = this.cuerpo.get(ultimoSegmento()).clone();
        generadorDeManzanas = new GeneradorDeManzanas(this.width, this.height);
        cronometro = new Cronometro();
        dialogPuntuacion = new DialogPuntuacion(FormMain.getFrames()[0], true);
    }

}
