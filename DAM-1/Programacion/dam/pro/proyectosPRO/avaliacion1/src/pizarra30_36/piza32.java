package pizarra30_36;

import java.util.Scanner;

public class piza32 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int edad;
		System.out.print("Dame unha idade de ni�o[1-7] ou de anciano[65-110]: ");
		edad = teclado.nextInt();

		while (edad >= 1 && edad <= 7 || edad >= 65 && edad <= 110) {
			if (edad >= 1 && edad <= 7)
				System.out.println("NI�O con " + edad + " a�os");
			else
				System.out.println("ANCIANO con " + edad + " a�os");
			edad = teclado.nextInt();
		}
		System.out.println("Esta idade: " + edad + " e INCORRECTA");
		teclado.close();
	}
}