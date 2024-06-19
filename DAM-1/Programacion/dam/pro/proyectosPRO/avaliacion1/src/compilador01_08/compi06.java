package compilador01_08;

import java.util.Scanner;

public class compi06 {
	public static void main(String[] ar) {
		int edad1, edad2, edad3;
		Scanner teclado = new java.util.Scanner(System.in);

		System.out.print("Edad del alumno 1: ");
		edad1 = teclado.nextInt();
		System.out.print("Edad del alumno 2: ");
		edad2 = teclado.nextInt();
		System.out.print("Edad del alumno 3: ");
		edad3 = teclado.nextInt();

		System.out.println("La edad media es " + (edad1 + edad2 + edad3) / 3.);

		teclado.close();
	}
}
