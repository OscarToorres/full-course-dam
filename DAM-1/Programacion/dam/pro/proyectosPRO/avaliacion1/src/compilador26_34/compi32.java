package compilador26_34;

import java.util.Scanner;

public class compi32 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		
		int tltTriangulos;
		int i = 0;
		int j = 0;
		
		float base;
		float altura;
		float superficie;

		System.out.print("TOTAL triangulos: ");
		tltTriangulos = teclado.nextInt();

		while (i < tltTriangulos) {
			System.out.print("**Dame base " + (i + 1) + ": ");
			base = teclado.nextInt();
			System.out.print("Dame altura " + (i + 1) + ": ");
			altura = teclado.nextInt();
			superficie = (base * altura) / 2;
			System.out.println("*Superficie " + (i + 1) + ": " + superficie);
			if (superficie > 12) {
				j++;
			}
			i++;
		}
		teclado.close();

		System.out.println("Triangulos con superficie superior a 12 son: " + j);

	}
}