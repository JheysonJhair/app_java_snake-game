package com.jhairdev.ui_threads;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Jhair
 */
public class GeneradorDeManzanas extends Thread {
    private boolean parar;
    private boolean manzanaComida;
    private final Random rand;
    private final int width;
    private final int height;
    private int x;
    private int y;
    private long startTime;

    public GeneradorDeManzanas(int width, int height) {
        parar = false;
        manzanaComida = false;
        rand = new Random();
        this.width = width;
        this.height = height;
    }

    @Override
    public void run() {
        generarManzana(); 
        startTime = System.currentTimeMillis(); 

        while (!this.parar) {
            try {
                Thread.sleep(100); 
            } catch (InterruptedException ex) {
                System.out.println("Generador de manzanas: Interrupción - Hilo parado");
            }
            synchronized (this) {
                if (manzanaComida) {
                    manzanaComida = false;
                    startTime = System.currentTimeMillis(); 
                } else if (System.currentTimeMillis() - startTime >= 5000) {
                    moverManzana();
                    startTime = System.currentTimeMillis(); 
                }
            }
        }
    }

    private synchronized void generarManzana() {
        boolean manzanaColocada = false;
        while (!manzanaColocada && !this.parar) {
            x = rand.nextInt(width);
            y = rand.nextInt(height);
            // log
            System.out.println("Generador de manzanas: Intentando colocar una manzana en las coordenadas " + x + "," + y);
            if (FormMain.tablero[x][y].getBackground() == Color.WHITE) {
                FormMain.tablero[x][y].setBackground(Color.RED);
                manzanaColocada = true;
                System.out.println("Generador de manzanas: Manzana colocada");
            }
        }
    }

    private synchronized void moverManzana() {
        if (FormMain.tablero[x][y].getBackground() == Color.RED) {
            FormMain.tablero[x][y].setBackground(Color.WHITE);
        }
        generarManzana();
    }

    public synchronized void manzanaDevorada() {

        FormMain.lblPuntuacionDato.setText((Integer.parseInt(FormMain.lblPuntuacionDato.getText()) + 100) + "");
        FormMain.lblManzanasDato.setText((Integer.parseInt(FormMain.lblManzanasDato.getText()) + 1) + "");
        moverManzana(); 
        manzanaComida = true; 
    }

    public void pararDeGenerar() {
        this.parar = true;
    }
}
