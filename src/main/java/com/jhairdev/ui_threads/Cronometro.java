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
            } else if (minutos >= 60) {
                pararCronometro();
            }
            try {
                Thread.sleep(1000);
                if (!parar) {
                    FormMain.lblTiempoDato.setText(String.format("%2d", minutos).replace(' ', '0') + ":" + String.format("%2d", segundos).replace(' ', '0'));
                }
            } catch (InterruptedException ex) {
                System.out.println("Hilo Cronometro: Se detuvo");
            }
        }
    }

    public void pararCronometro() {
        this.parar = true;
    }
}
