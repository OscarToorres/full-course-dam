package compilador50_55;

import java.util.Scanner;

public class compi54 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int numero;
		float numero2;
		String cadena;

		System.out.println("\n  M E N U");
		System.out.println("  =======");
		System.out.println(" 1.- Dame un ENTERO");
		System.out.println(" 2.- Dame un REAL");
		System.out.println(" 3.- Dame una CADENA");
		System.out.println(" 4.- FINAL");
		numero = teclado.nextInt();
		teclado.nextLine();
		
		while (numero != 4) {

			switch (numero) {
			case 1:
				System.out.print(" ENTERO: ");
				numero = teclado.nextInt();
				System.out.println("ENTERO pulsado: " + numero);
				break;
			case 2:
				System.out.print(" REAL: ");
				numero2 = teclado.nextFloat();
				System.out.println("REAL pulsado: " + numero2);
				break;
			case 3:
				System.out.print(" CADENA: ");
				//teclado.nextLine();
				cadena = teclado.nextLine();
				System.out.println("CADENA pulsada: " + cadena);
				break;
			default:
				System.out.println("OPCION Erronea");
				break;
			}
			System.out.println("\n  M E N U");
			System.out.println("  =======");
			System.out.println(" 1.- Dame un ENTERO");
			System.out.println(" 2.- Dame un REAL");
			System.out.println(" 3.- Dame una CADENA");
			System.out.println(" 4.- FINAL");
			numero = teclado.nextInt();
			teclado.nextLine();
		}
		System.out.println("FINAL");
		teclado.close();
	}
}