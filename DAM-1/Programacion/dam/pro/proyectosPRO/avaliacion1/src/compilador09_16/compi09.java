package compilador09_16;

import java.util.Scanner;

public class compi09 {
	public static void main(String[] ar) {
		int numero1, numero2;
		Scanner teclado = new java.util.Scanner(System.in);

		System.out.print("Dame numero 1: ");
		numero1 = teclado.nextInt();
		System.out.print("Dame numero 2: ");
		numero2 = teclado.nextInt();
		teclado.close();

		System.out.println("La sumas es ------------>" + (numero1 + numero2));
		System.out.println("La resta es ----------->" + (numero1 - numero2) + ("  (numero1-numero2)"));
		System.out.println("La multiplicacion es -->" + (numero1 * numero2));
		System.out.println("La division entera es ->" + (numero1 / numero2) + ("  (numero1/numero2)"));
		System.out.println("El modulo es ---------->" + (numero1 % numero2) + ("  numero1%numero2"));
		System.out.println("La division real es --->" + ((float) numero1 / numero2) + ("  (numero1/numero2)"));
		System.out.println("La media real es ------>" + ((float) (numero1 + numero2) / 2));
	}
}