package org.iesalandalus.programacion.reinaajedrez.modelo;

import javax.naming.OperationNotSupportedException;

public class Reina {

    private Color color;
    private Posicion posicion;

    // CONSTRUCTORES
    public Reina() {
        color = Color.BLANCO;
        posicion = new Posicion(1, 'd');
    }

    public Reina(Color color) {
        setColor(color);

        if (color == Color.BLANCO) {
            posicion = new Posicion(1, 'd');
        } else if (color == Color.NEGRO) {
            posicion = new Posicion(8, 'd');
        }
    }

    // SETCOLOR & GETCOLOR
    private void setColor(Color color) throws IllegalArgumentException {
        if (color == null) {
            throw new IllegalArgumentException("ERROR: Color nulo.");
        } else {
            this.color = color;
        }
    }

    public Color getColor() {
        return this.color;
    }

    // SETPOSICION & GETPOSICION
    private void setPosicion(Posicion posicion) throws IllegalArgumentException {
        if (posicion == null) {
            throw new IllegalArgumentException("ERROR: Posición nula.");
        } else {
            this.posicion = posicion;
        }

    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    // MÉTODO MOVER
    public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
        if (direccion == null) {
            throw new NullPointerException("ERROR: La dirección no puede ser nula.");
        } else if (pasos < 1 || pasos > 7) {
            throw new IllegalArgumentException("ERROR: El número de pasos debe estar comprendido entre 1 y 7.");
        }

        switch (direccion) {

            case NORTE:

                if ((posicion.getFila() + pasos) > 8) {
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                } else {
                    setPosicion(new Posicion(posicion.getFila() + pasos, posicion.getColumna()));
                }
                break;

            case NORESTE:

                if (((posicion.getFila() + pasos) > 8) || ((posicion.getColumna() + pasos) > 'h')) {
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                } else {
                    setPosicion(new Posicion(posicion.getFila() + pasos, (char) (posicion.getColumna() + pasos)));
                }
                break;

            case ESTE:

                if ((posicion.getColumna() + pasos) > 'h') {
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                } else {
                    setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + pasos)));
                }
                break;

            case SURESTE:

                if (((posicion.getFila() - pasos) < 1) || ((posicion.getColumna() + pasos) > 'h')) {
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                } else {
                    setPosicion(new Posicion(posicion.getFila() - pasos, (char) (posicion.getColumna() + pasos)));
                }
                break;

            case SUR:

                if ((posicion.getFila() - pasos) < 1) {
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                } else {
                    setPosicion(new Posicion(posicion.getFila() - pasos, posicion.getColumna()));
                }
                break;

            case SUROESTE:

                if (((posicion.getFila() - pasos) < 1) || ((posicion.getColumna() - pasos) < 'a')) {
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                } else {
                    setPosicion(new Posicion(posicion.getFila() - pasos, (char) (posicion.getColumna() - pasos)));
                }
                break;

            case OESTE:

                if ((posicion.getColumna() - pasos) < 'a') {
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                } else {
                    setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - pasos)));
                }
                break;

            case NOROESTE:

                if (((posicion.getFila() + pasos) > 8) || ((posicion.getColumna() - pasos) < 'a')) {
                    throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
                } else {
                    setPosicion(new Posicion(posicion.getFila() + pasos, (char) (posicion.getColumna() - pasos)));
                }
                break;

        }

    }

    @Override
    public String toString() {
        return "color=" + color + ", posicion=(" + posicion + ")";
    }

}
