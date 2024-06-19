package compilador301_304;

import misClases.utilidades.Leer;

public class compi304 {

	public static void main(String[] args) {
		short dato_short;
		int dato_int;
		long dato_long;
		float dato_float;
		double dato_double;
		String dato_string;
		char dato_char;
		
		System.out.print("Dato char: ");
		dato_char = Leer.datoChar();
		System.out.print("Dato string: ");
		dato_string = Leer.datoString();
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
		
		System.out.println(dato_char);
		System.out.println(dato_string);
		System.out.println(dato_short);
		System.out.println(dato_int);
		System.out.println(dato_long);
		System.out.println(dato_float);
		System.out.println(dato_double);
	
	
	}
}
