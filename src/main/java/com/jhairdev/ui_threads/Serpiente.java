package com.jhairdev.ui_threads;

import com.jhairdev.ui_threads.DialogPuntuacion;
import com.jhairdev.ui_threads.FormMain;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Serpiente extends Thread {
    // Indicador para cuando se muera la serpiente
    private boolean estaViva;
    // Hilo que genera manzanas en el tablero
    private GeneradorDeManzanas generadorDeManzanas;
    // Hilo que genera bonificadores de velocidad
    // Cronometro que cuenta el tiempo de juego
    private Cronometro cronometro;
    // Posiciones de la serpiente
    private List<int[]> cuerpo;
    // parte de la cola especifica, para poder añadir secciones
    private int[] cola;
    // Tamaño del tablero
    private final int width;
    private final int height;
    // velocidad a la que se mueve la ser
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
                // Guarda la posición de la cola por si hay que añadir segmentos
                this.cola = this.cuerpo.get(ultimoSegmento()).clone();
                // Mueve el cuerpo
                for (int i = ultimoSegmento(); i >= 0; i--) {
                    switch (this.cuerpo.get(i)[2]) {
                        case KeyEvent.VK_A: // Izquierda
                        case KeyEvent.VK_LEFT:
                            this.cuerpo.get(i)[0]--;
                            break;
                        case KeyEvent.VK_D: // Derecha
                        case KeyEvent.VK_RIGHT:
                            this.cuerpo.get(i)[0]++;
                            break;
                        case KeyEvent.VK_W: // Arriba
                        case KeyEvent.VK_UP:
                            this.cuerpo.get(i)[1]--;
                            break;
                        case KeyEvent.VK_S: // Abajo
                        case KeyEvent.VK_DOWN:
                            this.cuerpo.get(i)[1]++;
                            break;
                    }
                    // Cambia la dirección para la siguiente vuelta
                    if (i > 0) {
                        this.cuerpo.get(i)[2] = this.cuerpo.get(i - 1)[2];
                    }
                }
                // Si con lo que choca es una manzana añade una sección al cuerpo
                if (FormMain.tablero[this.cuerpo.get(0)[0]][this.cuerpo.get(0)[1]].getBackground() == Color.RED) {
                    añadirCuerpo();
                // Si con lo que choca es un boost de velocidad aumenta la velocidad y continua su camino
                } else if (FormMain.tablero[this.cuerpo.get(0)[0]][this.cuerpo.get(0)[1]].getBackground() == Color.BLUE) {
                    // Borra la cola
                    FormMain.tablero[this.cola[0]][this.cola[1]].setBackground(Color.WHITE);
                // Si no choca con nada continua con su camino de forma normal
                } else {
                    // Borra la cola
                    FormMain.tablero[this.cola[0]][this.cola[1]].setBackground(Color.WHITE);
                }
                // Colorea el cuerpo
                FormMain.tablero[this.cuerpo.get(0)[0]][this.cuerpo.get(0)[1]].setBackground(Color.BLACK);
                try {
                    Thread.sleep((long) velocidad);
                } catch (InterruptedException ex) {
                    System.out.println("Serpiente: Interrupción - Hilo parado");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            // Puedes manejar aquí cualquier excepción que desees capturar
        } finally {
            // Cuando la serpiente muere
            morir();
        }
    }

    private int ultimoSegmento() {
        return this.cuerpo.size() - 1;
    }

    public void setDireccion(int direccion) {
        // Establece la dirección de la cabeza
        this.cuerpo.get(0)[2] = direccion;
    }

    /**
     * Añade un segmento al cuerpo de la serpiente
     */
    private void añadirCuerpo() {
        this.cuerpo.add(this.cola.clone());
        // Notifica al generador de manzanas que se ha devorado una manzana
        generadorDeManzanas.manzanaDevorada();
        // Log
        System.out.println("Serpiente: Manzana devorada");
    }

    /**
     * Detiene la ejecución del hilo y muestra el diálogo de puntuación
     */
    private void morir() {
        cronometro.pararCronometro();
        generadorDeManzanas.pararDeGenerar();
        // Log
        System.out.println("Serpiente: La serpiente ha muerto");
        // Muestra el diálogo de puntuación
        dialogPuntuacion.iniciar();
        dialogPuntuacion.setVisible(true);
        this.estaViva = false;
    }

    private void init() {
        // Inicia la serpiente
        this.estaViva = true;
        // Inicia el cuerpo de la serpiente
        this.cuerpo = new ArrayList<>();
        /*
        El cuerpo se compone de arrays de 3 ints:
        posición 0 = La posición x en el tablero
        posición 1 = La posición y en el tablero
        posición 2 = La dirección de la parte del cuerpo
        */
        // Cabeza
        FormMain.tablero[this.width / 2][this.height / 2].setBackground(Color.BLACK);
        this.cuerpo.add(new int[]{this.width / 2, this.height / 2, KeyEvent.VK_W});  // Inicialmente moviéndose hacia arriba
        // Guardamos la cola
        this.cola = this.cuerpo.get(ultimoSegmento()).clone();
        generadorDeManzanas = new GeneradorDeManzanas(this.width, this.height);
        cronometro = new Cronometro();
        dialogPuntuacion = new DialogPuntuacion(FormMain.getFrames()[0], true);
    }

}
