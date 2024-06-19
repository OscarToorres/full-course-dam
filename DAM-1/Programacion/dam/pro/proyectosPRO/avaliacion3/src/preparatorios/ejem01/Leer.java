﻿package preparatorios.ejem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leer {

	public static String dato() {
		String sdato = "";
		try {
			// Definir un flujo de caracteres de entrada: flujoE
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader flujoE = new BufferedReader(isr);
			// Leer. La entrada finaliza al pulsar la tecla Entrar
			sdato = flujoE.readLine();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		return sdato; // devolver el dato tecleado
	}

	public static char datoChar() {
		return dato().charAt(0);
	}

	public static String datoString() {
		return dato();
	}

	public static short datoShort() {
		try {
			return Short.parseShort(dato());
		} catch (NumberFormatException e) {
			System.out.print("Dato short INVALIDO. Teclee otro: ");
			return datoShort();
		}
	}

	public static int datoInt() {
		try {
			return Integer.parseInt(dato());
		} catch (NumberFormatException e) {
			System.out.print("Dato int INVALIDO. Teclee otro: ");
			return datoInt();
		}
	}

	public static long datoLong() {
		try {
			return Long.parseLong(dato());
		} catch (NumberFormatException e) {
			System.out.print("Dato long INVALIDO. Teclee otro: ");
			return datoLong();
		}
	}

	public static float datoFloat() {
		try {
			return Float.parseFloat(dato());
		} catch (NumberFormatException e) {
			System.out.print("Dato float INVALIDO. Teclee otro: ");
			return datoFloat();
		}
	}

	public static double datoDouble() {
		try {
			return Double.parseDouble(dato());
		} catch (NumberFormatException e) {
			System.out.print("Dato double INVALIDO. Teclee otro: ");
			return datoDouble();
		}
	}
}
