package compilador01_08;

import java.util.Scanner;

public class compi07 {
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

		System.out.println("Los años de Uxia son " + edad1 / 12);
		System.out.println("Los años de Maruxa son " + edad2 / 12);
		System.out.println("Los años de Anxo son " + edad3 / 12);
	}
}
