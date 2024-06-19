package compilador26_34;

import java.util.Scanner;

public class compi33 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int num;
		int suma = 0;
		int i = 0;

		System.out.println();

		while (i < 6) {
			System.out.print("Ingrese valor " + (i + 1) + ": ");
			num = teclado.nextInt();
			if (i < 3) {
			} else {
				suma = suma + num;
			}
			i++;
		}

		teclado.close();
		System.out.println("La suma de los ultimos 3 valores es: " + suma);

	}
}