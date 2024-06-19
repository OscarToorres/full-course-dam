package pizarra15_22;

import java.util.Scanner;

public class piza22 {

	public static void main(String[] args) {

		Scanner teclado = new java.util.Scanner(System.in);
		int num1;
		int num2;

		System.out.print("Dame el primer numero: ");
		num1 = teclado.nextInt();
		System.out.print("Dame el segundo numero: ");
		num2 = teclado.nextInt();
		teclado.close();
		
		if (num1 < 0 && num2 < 0) {
			System.out.println("Los dos son NEGATIVOS");
		} else if (num1 < 0 || num2 < 0) {
			System.out.println("Uno de los dos es NEGATIVO");
		} else {
			System.out.println("Los dos son POSITIVOS");
		}
	}
}