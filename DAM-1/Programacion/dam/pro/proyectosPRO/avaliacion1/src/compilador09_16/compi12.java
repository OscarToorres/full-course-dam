package compilador09_16;

import java.util.Scanner;

public class compi12 {
	public static void main(String[] ar) {
		int n1, n2;
		Scanner teclado = new java.util.Scanner(System.in);

		System.out.print("Ingrese primer valor: ");
		n1 = teclado.nextInt();
		System.out.print("Ingrese segundo valor: ");
		n2 = teclado.nextInt();
		teclado.close();

		if (n1 > n2) {
			System.out.println("La suma ---------------> " + (n1 + n2));
			System.out.println("La diferencia ---------> " + (n1 - n2));
		}
		if (n1 < n2) {
			System.out.println("El producto -----------> " + n1 * n2);
			System.out.println("La division (Entera) --> " + n2 / n1);
		}

	}
}