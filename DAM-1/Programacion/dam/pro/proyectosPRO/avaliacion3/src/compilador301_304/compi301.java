package compilador301_304;

import misClases.utilidades.LeerSimple;

public class compi301 {

	public static void main(String[] args) {
		short dato_short;
		int dato_int;
		long dato_long;
		float dato_float;
		double dato_double;
		
		System.out.print("Dato short: ");
		dato_short = LeerSimple.datoShort();
		System.out.print("Dato int: ");
		dato_int = LeerSimple.datoInt();
		System.out.print("Dato long: ");
		dato_long = LeerSimple.datoLong();
		System.out.print("Dato float: ");
		dato_float = LeerSimple.datoFloat();
		System.out.print("Dato double: ");
		dato_double = LeerSimple.datoDouble();
		
		System.out.println(dato_short);
		System.out.println(dato_int);
		System.out.println(dato_long);
		System.out.println(dato_float);
		System.out.println(dato_double);
	
	
	}
}
