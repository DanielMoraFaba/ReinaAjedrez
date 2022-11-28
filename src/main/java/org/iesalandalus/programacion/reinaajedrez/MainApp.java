package org.iesalandalus.programacion.reinaajedrez;

import org.iesalandalus.programacion.reinaajedrez.modelo.Reina;
import javax.naming.OperationNotSupportedException;
import static org.iesalandalus.programacion.reinaajedrez.Consola.despedida;

public class MainApp {

	public static void main(String[] args) {

		do {
			Consola.mostrarMenu();
			ejecutarOpcion(Consola.elegirOpcionMenu());
		} while (!salir);

	}

	static Reina reina;
	static boolean salir = false;

	public static void ejecutarOpcion(int eleccion) {

		switch (eleccion) {

			case 1:
				crearReinaDefecto();
				break;

			case 2:
				crearReinaColor();
				break;

			case 3:
				mover();
				break;

			case 4:
				despedida();
				salir = true;
				break;
		}

	}

	public static void crearReinaDefecto() {

		try {
			reina = new Reina();
			mostrarReina();
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void crearReinaColor() {

		try {
			reina = new Reina(Consola.elegirColor());
			mostrarReina();
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void mover() {

		try {
			Consola.mostrarMenuDirecciones();
			reina.mover(Consola.elegirDireccion(), Consola.elegirPasos());
			mostrarReina();
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			throw new RuntimeException(e);
		}

	}

	public static void mostrarReina() {
		System.out.println(reina.toString());
	}

}
