package pizarra15_22;

import java.util.Scanner;

public class piza16 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int edad;

		System.out.print("Dame una EDAD HUMANA: ");
		edad = teclado.nextInt();
		teclado.close();

		if (edad >= 0 && edad <= 17) {
			System.out.println("MENOR de edad con " + edad + " años");
			System.out.println("PRHIBIDO pasar a la sala de cine");
		} else if (edad >= 18 && edad <= 110) {
			System.out.println("MAYOR de edad con " + edad + " años");
			System.out.println("PASE a la sala de cine");
		} else {
			System.out.println("Tener " + edad + " no esta CONTEMPLADO");
			System.out.println("CIERREN la sala de cine");
		}
	}
}