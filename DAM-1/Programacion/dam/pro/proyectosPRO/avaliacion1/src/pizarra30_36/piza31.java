package pizarra30_36;

import java.util.Scanner;

public class piza31 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int edad;
		System.out.print("Dame unha idade de ni�o[1-7] ou de anciano[65-110]: ");
		edad = teclado.nextInt();

		while (edad < 1 || edad > 7 && edad < 65 || edad > 110) {
			System.out.print("Dame unha idade de ni�o[1-7] ou de anciano[65-110]: ");
			edad = teclado.nextInt();
		}
		System.out.print("FINAL");
		teclado.close();
	}
}