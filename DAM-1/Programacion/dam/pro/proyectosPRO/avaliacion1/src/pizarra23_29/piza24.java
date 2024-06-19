package pizarra23_29;

import java.util.Scanner;

public class piza24 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int numero;
		int i = 0;

		System.out.print("Dame un numero en 10 y 50: ");
		numero = teclado.nextInt();

		while (numero >= 10 && numero <= 50) {
			if (numero % 3 == 0) {
				i++;
			}
			System.out.print("Dame un numero entre 10 y 50: ");
			numero = teclado.nextInt();
		}
		teclado.close();
		System.out.println("Has introducido " + i + " multiplos de 3 entre 10 y 50");
	}
}