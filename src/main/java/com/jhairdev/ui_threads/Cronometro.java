package com.jhairdev.ui_threads;

/**
 *
 * @author Jhair
 */
public class Cronometro extends Thread {

    private int minutos;
    private int segundos;
    private boolean parar;

    public Cronometro() {
        this.minutos = 0;
        this.segundos = 0;
        this.parar = false;
    }

    @Override
    public void run() {
        while (!parar) {
            segundos++;
            if (segundos >= 60) {
                segundos = 0;
                minutos++;
            }
            try {
                Thread.sleep(1000);
                if (!parar) {
                    FormMain.lblTiempoDato.setText(String.format("%02d", minutos) + ":" + String.format("%02d", segundos));
                }
            } catch (InterruptedException ex) {
                System.out.println("Hilo Cronometro: Se detuvo");
            }
        }
    }

    public void pararCronometro() {
        this.parar = true;
        System.out.println("Cronometro detenido!");
    }
}
