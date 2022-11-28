package org.iesalandalus.programacion.reinaajedrez.modelo;

import java.util.Objects;

public class Posicion {

    private int fila;
    private char columna;

    // CONSTRUCTORES
    public Posicion(int fila, char columna) throws IllegalArgumentException {
        if (fila < 1 || fila > 8) {
            throw new IllegalArgumentException("ERROR: Fila no válida.");
        } else if (columna < 'a' || columna > 'h') {
            throw new IllegalArgumentException("ERROR: Columna no válida.");
        } else {
            setFila(fila);
            setColumna(columna);
        }
    }

    public Posicion(Posicion posicion) {
        this.fila = posicion.getFila();
        this.columna = posicion.getColumna();
    }

    // SETFILA & GETFILA
    private void setFila(int fila) throws IllegalArgumentException {
        if (fila < 1 || fila > 8) {
            throw new IllegalArgumentException("ERROR: Fila no válida.");
        } else {
            this.fila = fila;
        }
    }

    public int getFila() {
        return this.fila;
    }

    // SETCOLUMNA & GETCOLUMNA
    private void setColumna(char columna) throws IllegalArgumentException {
        if (columna < 'a' || columna > 'h') {
            throw new IllegalArgumentException("ERROR: Columna no válida.");
        } else {
            this.columna = columna;
        }
    }

    public char getColumna() {
        return this.columna;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Posicion posicion)) return false;
        return getFila() == posicion.getFila() && getColumna() == posicion.getColumna();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFila(), getColumna());
    }

    @Override
    public String toString() {
        return "fila=" + fila + ", columna=" + columna;
    }

}
