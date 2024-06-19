package compilador50_55;

import java.util.Scanner;

public class compi50 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int numero;

		System.out.print("Número entre 1 y el 5 (FINAL cualquier otro): ");
		numero = teclado.nextInt();

		while (numero >= 1 && numero <= 5) {
			switch (numero) {
			case 1:
				System.out.println("Es el " + numero);
				break;
			case 2:
				System.out.println("Es el " + numero);
				break;
			case 3:
				System.out.println("Es el " + numero);
				break;
			case 4:
				System.out.println("Es el " + numero);
				break;
			case 5:
				System.out.println("Es el " + numero);
				break;
			}
			System.out.print("Número entre 1 y el 5 (FINAL cualquier otro): ");
			numero = teclado.nextInt();
		}
		System.out.println("FINAL");
		teclado.close();
	}
}