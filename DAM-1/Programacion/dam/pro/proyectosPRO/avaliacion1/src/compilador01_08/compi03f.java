package compilador01_08;

import java.util.Scanner;

public class compi03f {
	public static void main(String[] ar) {
		float base, altura;
		Scanner teclado = new java.util.Scanner(System.in);

		System.out.print("Dame a base: ");
		base = teclado.nextFloat();
		System.out.print("Dame a altura: ");
		altura = teclado.nextFloat();
		System.out.print("Area do triangulo: " + base * altura / 2.);
		teclado.close();
	}
}
