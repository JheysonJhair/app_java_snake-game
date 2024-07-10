package com.jhairdev.ui_threads;

import com.jhairdev.ui_threads.FormMain;

/**
 *
 * @author Alejandro González Navarro
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
            // Suma un segundo
            segundos++;
            if (segundos >= 60) {
                segundos = 0;
                minutos++;
            } else if (minutos >= 60) {
                pararCronometro();
            }
            try {
                Thread.sleep(1000);
                // si cuando acaba el segundo se establece parar no cuenta el último segundo
                if (!parar) {
                    // reduce la puntuación cada segundo si es 10 o menos establece a 0
                    if (Integer.parseInt(FormMain.jLabelPuntuacionC.getText()) < 10) {
                        FormMain.jLabelPuntuacionC.setText(0 + "");
                    } else {
                        FormMain.jLabelPuntuacionC.setText((Integer.parseInt(FormMain.jLabelPuntuacionC.getText()) - 10) + "");
                    }
                    // Actualiza el cronómetro visualmente en la interfaz
                    FormMain.jLabelTiempoC.setText(String.format("%2d", minutos).replace(' ', '0') + ":" + String.format("%2d", segundos).replace(' ', '0'));
                }
            } catch (InterruptedException ex) {
                System.out.println("Cronometro: Interrupción - Hilo parado");
            }
        }
    }

    public void pararCronometro() {
        this.parar = true;
    }
}
