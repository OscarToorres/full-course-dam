package misClases.avaliacion2;

import java.util.Scanner;

public class CDameDato {

	private int datoInt;
	private float datoFloat;
	private String datoString;
	private Scanner teclado = new java.util.Scanner(System.in);

	public int recogerDatoEntero() {
		System.out.print(" ENTERO: ");
		datoInt = teclado.nextInt();
		System.out.println("ENTERO pulsado: " + datoInt);
	return datoInt;
	
}
	public void devuelveResultadoInt () {
		System.out.println(datoInt);
	}

	public float recogerDatoFloat() {
		System.out.print(" REAL: ");
		datoFloat = teclado.nextFloat();
		System.out.println("REAL pulsado: " + datoFloat);
		return datoFloat;
	}
	
	public void devuelveResultadoFloat() {
		System.out.println(datoFloat);
	}
	
	public String recogerDatoString() {
		teclado.nextLine();
		System.out.print(" CADENA: ");
		datoString = teclado.nextLine();
		System.out.println("CADENA pulsada: " + datoString);
		return datoString;
	}
	
	public int menu() {
		System.out.println("\n  M E N U");
		System.out.println("  =======");
		System.out.println(" 1.- Dame un ENTERO");
		System.out.println(" 2.- Dame un REAL");
		System.out.println(" 3.- Dame una CADENA");
		System.out.println(" 4.- FINAL");
		
		datoInt = teclado.nextInt();
		return datoInt;
	}
	
	public void menuCompleto() {
		CDameDato Respuesta = new CDameDato();
		int numero = 0;
		
		do {
			numero = Respuesta.menu();
			
			switch (numero) {
			case 1:
				Respuesta.recogerDatoEntero();
				break;
			case 2:
				Respuesta.recogerDatoFloat();
				break;
			case 3:
				Respuesta.recogerDatoString();
				break;
			case 4:
				System.out.println("FINAL");
				break;
			default:
				System.out.println("OPCION Erronea");
				break;
			}
		} while(numero != 4) ;
	}

}
