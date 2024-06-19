package pizarra01_07;

import java.util.Scanner;

public class pizza03 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int num;

		System.out.print("Dame un número menor que 20: ");
		num = teclado.nextInt();
		teclado.close();

		while (num <= 20) {
			System.out.println(num);
			num++;

		}
	}
}
