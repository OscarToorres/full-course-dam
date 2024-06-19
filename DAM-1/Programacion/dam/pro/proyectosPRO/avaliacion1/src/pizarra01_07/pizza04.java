package pizarra01_07;

import java.util.Scanner;

public class pizza04 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int num;
		int i = 20;

		System.out.print("Dame un número menor que 20: ");
		num = teclado.nextInt();
		teclado.close();

		while (num <= i) {
			System.out.println(i);
			i = i - 1;
		}
	}
}
