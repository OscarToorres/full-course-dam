package pizarra23_29;

import java.util.Scanner;

public class piza27 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			System.out.println("Tabla de multiplicar del " + i);
			for (int j = 1; j <= 10; j++) {
				System.out.println(i + " X " + j + " = " + i * j);
			}
			teclado.nextLine();
		}
		teclado.close();
	}

}
