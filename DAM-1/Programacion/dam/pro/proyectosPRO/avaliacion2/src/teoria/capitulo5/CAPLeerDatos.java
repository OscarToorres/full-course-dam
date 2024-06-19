package teoria.capitulo5;

import misClases.teoria.Leer;

public class CAPLeerDatos {

	public static void main(final String[] args) {
		short dato_short = 0;
		int dato_int = 0;
		long dato_long = 0L;
		float dato_float = 0.0f;
		double dato_double = 0.0;

		System.out.print("Dato short: ");
		dato_short = Leer.datoShort();
		System.out.print("Dato int: ");
		dato_int = Leer.datoInt();
		System.out.print("Dato long: ");
		dato_long = Leer.datoLong();
		System.out.print("Dato float: ");
		dato_float = Leer.datoFloat();
		System.out.print("Dato double: ");
		dato_double = Leer.datoDouble();
		System.out.println(dato_short);
		System.out.println(dato_int);
		System.out.println(dato_long);
		System.out.println(dato_float);
		System.out.println(dato_double);
	}
}
