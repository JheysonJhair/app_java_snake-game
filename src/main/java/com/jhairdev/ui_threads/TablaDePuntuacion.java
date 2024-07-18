package com.jhairdev.ui_threads;

public class TablaDePuntuacion {

    private String[][] tabla;

    public TablaDePuntuacion() {
        this.tabla = new String[3][2];
        for (int i = 0; i < 3; i++) {
            tabla[i][0] = "0";
            tabla[i][1] = "0";
        }
    }

    public void mostrarTabla() {
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + tabla[i][0] + ": " + tabla[i][1]);
        }
    }

    public String[][] recuperarLista() {
        return this.tabla;
    }
}
