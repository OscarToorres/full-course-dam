package compilador01_08;

import java.util.Scanner;

public class compi08 {
	public static void main(String[] ar) {
		int edad1, edad2, edad3;
		Scanner teclado = new java.util.Scanner(System.in);

		System.out.print("Edad de Uxia (EN MESES): ");
		edad1 = teclado.nextInt();
		System.out.print("Edad de Maruxa (EN MESES): ");
		edad2 = teclado.nextInt();
		System.out.print("Edad de Anxo (EN MESES): ");
		edad3 = teclado.nextInt();
		teclado.close();

		System.out.println("Uxia tiene " + edad1 / 12 + " años y " + edad1 % 12 + " meses");
		System.out.println("maruxa tiene " + edad2 / 12 + " años y " + edad2 % 12 + " meses");
		System.out.println("Anxo tiene " + edad3 / 12 + " años y " + edad3 % 12 + " meses");
	}
}