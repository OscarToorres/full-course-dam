package compilador301_304;

import misClases.utilidades.LeerMejorado;

public class compi302 {

	public static void main(String[] args) {
		short dato_short;
		int dato_int;
		long dato_long;
		float dato_float;
		double dato_double;
		
		System.out.print("Dato short: ");
		dato_short = LeerMejorado.datoShort();
		System.out.print("Dato int: ");
		dato_int = LeerMejorado.datoInt();
		System.out.print("Dato long: ");
		dato_long = LeerMejorado.datoLong();
		System.out.print("Dato float: ");
		dato_float = LeerMejorado.datoFloat();
		System.out.print("Dato double: ");
		dato_double = LeerMejorado.datoDouble();
		
		System.out.println(dato_short);
		System.out.println(dato_int);
		System.out.println(dato_long);
		System.out.println(dato_float);
		System.out.println(dato_double);
	
	
	}
}
