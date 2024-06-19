package compilador301_304;

import misClases.utilidades.LeerMejor;

public class compi303 {

	public static void main(String[] args) {
		short dato_short;
		int dato_int;
		long dato_long;
		float dato_float;
		double dato_double;
		
		System.out.print("Dato short: ");
		dato_short = LeerMejor.datoShort();
		System.out.print("Dato int: ");
		dato_int = LeerMejor.datoInt();
		System.out.print("Dato long: ");
		dato_long = LeerMejor.datoLong();
		System.out.print("Dato float: ");
		dato_float = LeerMejor.datoFloat();
		System.out.print("Dato double: ");
		dato_double = LeerMejor.datoDouble();
		
		System.out.println(dato_short);
		System.out.println(dato_int);
		System.out.println(dato_long);
		System.out.println(dato_float);
		System.out.println(dato_double);
	
	
	}
}
