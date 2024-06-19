package pizarra30_36;

import java.util.Scanner;

public class piza30 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int numero;
		System.out.print("Dame un numero entre 1 e 20: ");
		numero = teclado.nextInt();
		
		while (numero < 1 || numero > 20) {
			System.out.print("Dame un numero entre 1 e 20: ");
			numero = teclado.nextInt();
		}
		System.out.println("FINAL");
		teclado.close();
	}
}