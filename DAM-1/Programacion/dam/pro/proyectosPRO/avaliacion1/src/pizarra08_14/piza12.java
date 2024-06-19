package pizarra08_14;

import java.util.Scanner;

public class piza12 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int a;
		int b;

		System.out.println("\nIngrese un valor a: ");
		a = teclado.nextInt();
		System.out.println("\nIngrese un valor b: ");
		b = teclado.nextInt();
		teclado.close();

		for (;a <= b; a++) {
			System.out.println(a);
		}
	}
}