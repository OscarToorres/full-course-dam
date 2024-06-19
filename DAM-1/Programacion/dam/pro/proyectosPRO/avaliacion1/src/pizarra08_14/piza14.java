package pizarra08_14;

import java.util.Scanner;

public class piza14 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);

		int num;
		int i = 0;
		int j = 0;

		System.out.print("\nIngrese un número: ");
		num = teclado.nextInt();
		teclado.close();

		for (; i < 10; i++) {
			j = (i + 1) * num;
			System.out.println((1 + i) + " * " + num + " = " + j);
		}
	}
}	