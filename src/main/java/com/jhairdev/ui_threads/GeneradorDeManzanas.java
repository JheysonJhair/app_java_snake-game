package com.jhairdev.ui_threads;

import com.jhairdev.ui_threads.FormMain;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Alejandro González Navarro
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
        generarManzana(); // Genera una manzana al inicio
        startTime = System.currentTimeMillis(); // Initialize start time

        while (!this.parar) {
            try {
                Thread.sleep(100); // Check every 100 milliseconds
            } catch (InterruptedException ex) {
                System.out.println("Generador de manzanas: Interrupción - Hilo parado");
            }
            
            synchronized (this) {
                if (manzanaComida) {
                    manzanaComida = false;
                    startTime = System.currentTimeMillis(); // Reset start time when an apple is eaten
                } else if (System.currentTimeMillis() - startTime >= 5000) {
                    moverManzana();
                    startTime = System.currentTimeMillis(); // Reset start time after moving the apple
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
                // log
                System.out.println("Generador de manzanas: Manzana colocada");
            }
        }
    }

    private synchronized void moverManzana() {
        if (FormMain.tablero[x][y].getBackground() == Color.RED) {
            FormMain.tablero[x][y].setBackground(Color.WHITE); // Elimina la manzana actual
        }
        generarManzana();
    }

    public synchronized void manzanaDevorada() {
        // Añade uno al contador de manzanas
        FormMain.jLabelPuntuacionC.setText((Integer.parseInt(FormMain.jLabelPuntuacionC.getText()) + 100) + "");
        FormMain.jLabelManzanasC.setText((Integer.parseInt(FormMain.jLabelManzanasC.getText()) + 1) + "");
        moverManzana(); // Mueve la manzana inmediatamente
        manzanaComida = true; // Set flag to indicate the apple was eaten
    }

    public void pararDeGenerar() {
        this.parar = true;
    }
}
