package compilador09_16;

import java.util.Scanner;

public class compi13 {
	public static void main(String[] ar) {
		int n1, n2, n3;
		float med;
		Scanner teclado = new java.util.Scanner(System.in);

		System.out.print("Ingrese la primera nota: ");
		n1 = teclado.nextInt();
		System.out.print("Ingrese la segunda nota: ");
		n2 = teclado.nextInt();
		System.out.print("Ingrese ña tercera nota: ");
		n3 = teclado.nextInt();
		teclado.close();

		med = (float) (n1 + n2 + n3) / 3;
		System.out.println("Su media ---> " + med);

		if (med >= 7) {
			System.out.println("PROMOCIONADO");
		}
	}
}