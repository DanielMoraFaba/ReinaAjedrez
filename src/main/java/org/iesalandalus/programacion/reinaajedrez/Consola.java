package org.iesalandalus.programacion.reinaajedrez;

import org.iesalandalus.programacion.reinaajedrez.modelo.Color;
import org.iesalandalus.programacion.reinaajedrez.modelo.Direccion;
import utilidades.*;

public class Consola {

    private Consola() {

    }

    public static void mostrarMenu() {
        System.out.println(" ============================================== ");
        System.out.println("| (1) Crear reina por defecto                  |");
        System.out.println("| (2) Crear reina eligiendo el color           |");
        System.out.println("| (3) Mover                                    |");
        System.out.println("| (4) Salir                                    |");
        System.out.println(" ============================================== ");
    }

    public static int elegirOpcionMenu() {

        int opcion;

        do {
            System.out.print("Elige una opción: ");
            opcion = Entrada.entero();
        } while (opcion < 1 && opcion > 4);

        return opcion;
    }

    public static Color elegirColor() {

        int color;

        do {
            System.out.println("Elige un color: (1) BLANCO / (2) NEGRO");
            color = Entrada.entero();
        } while (color < 1 && color > 2);

        if (color == 1) {
            return Color.BLANCO;
        } else {
            return Color.NEGRO;
        }

    }

    public static void mostrarMenuDirecciones() {
        System.out.println(" ======================================================= ");
        System.out.println("| (8) NOROESTE          (1) NORTE          (2) NORESTE  |");
        System.out.println("|                                                       |");
        System.out.println("|                                                       |");
        System.out.println("| (7) OESTE                                (3) ESTE     |");
        System.out.println("|                                                       |");
        System.out.println("|                                                       |");
        System.out.println("| (6) SUROESTE          (5) SUR            (4) SURESTE  |");
        System.out.println(" ======================================================= ");
    }

    public static Direccion elegirDireccion() {

        int entrada;
        Direccion direccion = null;

        do {
            System.out.print("Elige una dirección: ");
            entrada = Entrada.entero();
        } while (entrada < 1 && entrada > 8);

        switch (entrada) {

            case 1:
                direccion = Direccion.NORTE;
                break;

            case 2:
                direccion = Direccion.NORESTE;
                break;

            case 3:
                direccion = Direccion.ESTE;
                break;

            case 4:
                direccion = Direccion.SURESTE;
                break;

            case 5:
                direccion = Direccion.SUR;
                break;

            case 6:
                direccion = Direccion.SUROESTE;
                break;

            case 7:
                direccion = Direccion.OESTE;
                break;

            case 8:
                direccion = Direccion.NOROESTE;
                break;
        }

        return direccion;

    }

    public static int elegirPasos() {

        int pasos;

        do {
            System.out.print("Elige el número de pasos: ");
            pasos = Entrada.entero();
        } while (pasos < 1 && pasos > 7);

        return pasos;
    }

    public static void despedida() {
        System.out.println("Adiós!!!");
    }

}