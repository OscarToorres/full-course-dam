package pizarra15_22;

import java.util.Scanner;

public class piza17 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int num;
		int numSecret;

		System.out.print("Dame una EDAD HUMANA: ");
		num = teclado.nextInt();
		teclado.close();

		if (num >= 1 && num <= 10) {
			System.out.println("Entre el 1 y el 10");
			numSecret = num * 4;
			System.out.println("Numero secreto: " + numSecret);
		} else if (num >= 11 && num <= 20) {
			System.out.println("Entre el 11 y el 20");
			numSecret = num * 3;
			System.out.println("Numero secreto: " + numSecret);
		} else if (num >= 21 && num <= 30) {
			System.out.println("Entre el 21 y el 30");
			numSecret = num * 2;
			System.out.println("Numero secreto: " + numSecret);
		}else {
			System.out.println("NUMERO no permitido: " + num);
		}
	}
}