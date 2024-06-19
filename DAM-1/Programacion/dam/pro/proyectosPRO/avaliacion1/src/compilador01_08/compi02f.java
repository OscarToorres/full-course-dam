package compilador01_08;

import java.util.Scanner;

public class compi02f {
	public static void main(String[] ar) {
		float base, altura, area;
		Scanner teclado = new java.util.Scanner(System.in);

		System.out.print("Dame a base: ");
		base = teclado.nextFloat();
		System.out.print("Dame a altura: ");
		altura = teclado.nextFloat();

		area = base * altura;
		System.out.print("Area do rectangulo: " + (int) area);
		teclado.close();
	}
}
