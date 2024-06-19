package compilador09_16;

import java.util.Scanner;

public class compi10 {
	public static void main(String[] ar) {
		int compra;
		float venta;
		Scanner teclado = new java.util.Scanner(System.in);

		System.out.print("Dame precio de compra: ");
		compra = teclado.nextInt();
		teclado.close();

		venta = (float) (compra + compra * 0.35);
		System.out.println("Precio de venta------> " + (float) venta);
		System.out.println("PVP -----------------> " + ((float) venta + venta * 0.18));
	}
}