package com.jhairdev.ui_threads;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Jhair
 */
public class ProcessApple extends Thread {

    private boolean parar;
    private boolean manzanaComida;
    private final int width;
    private final int height;
    private final Random rand;
    private int x;
    private int y;
    private long startTime;

    public ProcessApple(int width, int height) {
        parar = false;
        manzanaComida = false;
        rand = new Random();
        this.width = width;
        this.height = height;
    }

    @Override
    public void run() {
        generarManzana();
        while (!this.parar) {
            try {
                if (manzanaComida) {
                    manzanaComida = false;
                    startTime = System.currentTimeMillis();
                } else if (System.currentTimeMillis() - startTime >= 5000) {
                    moverManzana();
                    startTime = System.currentTimeMillis();
                }
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Generador de manzanas: Interrupción - Hilo parado");
            }
        }
    }

    private void generarManzana() {
        boolean manzanaColocada = false;
        while (!manzanaColocada && !this.parar) {
            x = rand.nextInt(width);
            y = rand.nextInt(height);       
            if (FormMain.tablero[x][y].getBackground() == Color.WHITE) {
                FormMain.tablero[x][y].setBackground(Color.RED);
                manzanaColocada = true;
                System.out.println("Generador de manzanas: Manzana colocada");
            }
           
        }    
    }

    private void moverManzana() {
        if (FormMain.tablero[x][y].getBackground() == Color.RED) {
            FormMain.tablero[x][y].setBackground(Color.WHITE);
        }
        generarManzana();
    }

    public void manzanaDevorada() {
        FormMain.lblPuntuacionDato.setText((Integer.parseInt(FormMain.lblPuntuacionDato.getText()) + 10) + "");
        FormMain.lblManzanasDato.setText((Integer.parseInt(FormMain.lblManzanasDato.getText()) + 1) + "");
        moverManzana();
        manzanaComida = true;
    }

    public void pararDeGenerar() {
        this.parar = true;
    }
}
