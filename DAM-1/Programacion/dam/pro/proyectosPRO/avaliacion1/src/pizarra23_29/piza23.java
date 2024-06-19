package pizarra23_29;

import java.util.Scanner;

public class piza23 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int num;
		
		System.out.print("Dame un numero entre 10 y 50: ");
		num = teclado.nextInt();
		while (num >= 10 && num <= 50) {
			System.out.print("Dame un numero entre 10 y 50: ");
			num = teclado.nextInt();
		}
		teclado.close();
		System.out.println("El numero " + num + " no esta entre 10 y 50");
	}
}
