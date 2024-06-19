package pizarra08_14;

import java.util.Scanner;

public class piza11 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int num;

		System.out.println("\nIngrese un numero: ");
		num = teclado.nextInt();
		teclado.close();

		for (int i = 20; i >= num; i = i - 1) {
			System.out.println(i);
		}
	}
}