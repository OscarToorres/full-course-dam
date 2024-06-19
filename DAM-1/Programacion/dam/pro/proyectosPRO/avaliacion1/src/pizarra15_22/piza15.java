package pizarra15_22;

import java.util.Scanner;

public class piza15 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int num1, num2;
		
		System.out.println("\nIngrese valor A: ");
		num1 = teclado.nextInt();
		System.out.println("\nIngrese valor B: ");
		num2 = teclado.nextInt();
		teclado.close();
		
		if (num1 > num2) {
			System.out.println("A es MAYOR que B");
		}else if (num1 < num2) {
			System.out.println("A es MENOR que B");
		}else {
			System.out.println("A es IGUAL que B");
		}
	}

}
