package compilador01_08;

import java.util.Scanner;

public class compi02 {
	public static void main(String[] ar) {
		int base, altura, area;
		Scanner teclado = new java.util.Scanner(System.in);

		System.out.print("Dame a base: ");
		base = teclado.nextInt();
		System.out.print("Dame a altura: ");
		altura = teclado.nextInt();

		area = base * altura;
		System.out.print("Area do rectangulo: " + area);
		teclado.close();
	}
}
