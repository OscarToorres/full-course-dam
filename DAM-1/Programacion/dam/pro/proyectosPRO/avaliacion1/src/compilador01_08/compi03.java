package compilador01_08;

import java.util.Scanner;

public class compi03 {
	public static void main(String[] ar) {

		int base, altura;
		Scanner teclado = new java.util.Scanner(System.in);

		System.out.print("Dame a base: ");
		base = teclado.nextInt();
		System.out.print("Dame a altura: ");
		altura = teclado.nextInt();

		System.out.print("Area do triangulo: " + base * altura / 2.);
		teclado.close();

	}
}