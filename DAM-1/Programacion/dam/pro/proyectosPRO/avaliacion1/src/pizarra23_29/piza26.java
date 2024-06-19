package pizarra23_29;

import java.util.Scanner;

public class piza26 {

	public static void main(String[] args) {
		int i, j;
		Scanner teclado = new java.util.Scanner(System.in);

		i = 1;
		while (i <= 10) {
			System.out.println("Tabla de multiplicar del " + i);
			j = 1;
			while (j <= 10) {
				System.out.println(i + " X " + j + " = " + i * j);
				j++;
			}
			i = i + 1;
			teclado.nextLine();
		}
		teclado.close();
	}

}
