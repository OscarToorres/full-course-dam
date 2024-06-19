package pizarra01_07;

import java.util.Scanner;

public class pizza06 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int a;
		int b;
		
		System.out.println("Ingrese un valor a: ");
		a = teclado.nextInt();
		System.out.println("Ingrese un valor b: ");
		b = teclado.nextInt();
		teclado.close();
		
		while (a >= b) {
			System.out.println(b);
			b++;
		}
			
	}

}
