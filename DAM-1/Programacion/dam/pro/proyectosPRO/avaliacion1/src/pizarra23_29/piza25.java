package pizarra23_29;

import java.util.Scanner;

public class piza25 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int numero;
		int i = 0;
		int j = 0;

		System.out.print("Dame un numero entre 1 y 100: ");
		numero = teclado.nextInt();

		while (numero >= 1 && numero <= 100) {
			if (numero >= 1 && numero <= 50)
				i++;
			else if (numero >= 51 && numero <= 100)
				j++;
			System.out.print("Dame un numero entre 1 y 100: ");
			numero = teclado.nextInt();
		}

		teclado.close();
		System.out.println("Entre 1 y 50 hubo " + i + " números");
		System.out.println("Entre 51 y 100 hubo " + j + " números");

	}

}