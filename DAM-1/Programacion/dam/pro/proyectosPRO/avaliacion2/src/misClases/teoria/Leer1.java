package misClases.teoria;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Leer1 {
	public static String dato() {
		String sdato = "";
		try {
			final InputStreamReader isr = new InputStreamReader(System.in);
			final BufferedReader flujoE = new BufferedReader(isr);
			sdato = flujoE.readLine();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		return sdato;
	}

	public static short datoShort() {
		try {
			final Short s = new Short(dato());
			return s;
		} catch (NumberFormatException e) {
			return -32768;
		}
	}

	public static int datoInt() {
		try {
			final Integer i = new Integer(dato());
			return i;
		} catch (NumberFormatException e) {
			return Integer.MIN_VALUE;
		}
	}

	public static long datoLong() {
		try {
			final Long l = new Long(dato());
			return l;
		} catch (NumberFormatException e) {
			return Long.MIN_VALUE;
		}
	}

	public static float datoFloat() {
		try {
			final Float f = new Float(dato());
			return f;
		} catch (NumberFormatException e) {
			return Float.NaN;
		}
	}

	public static double datoDouble() {
		try {
			final Double d = new Double(dato());
			return d;
		} catch (NumberFormatException e) {
			return Double.NaN;
		}
	}
}