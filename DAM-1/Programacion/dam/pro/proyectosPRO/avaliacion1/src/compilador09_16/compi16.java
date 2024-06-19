package compilador09_16;

import java.util.Scanner;

public class compi16 {
	public static void main(String[] ar) {
		int n1;
		Scanner teclado = new java.util.Scanner(System.in);

		System.out.print("Ingre un valor: ");
		n1 = teclado.nextInt();
		teclado.close();

		if (n1 > 0) {
			System.out.println("POSITIVO");
		}
		if (n1 < 0) {
			System.out.println("NEGATIVO");
		}
		if (n1 == 0) {
			System.out.println("NULO");
		}
	}
}