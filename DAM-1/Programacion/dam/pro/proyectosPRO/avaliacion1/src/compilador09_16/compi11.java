package compilador09_16;

import java.util.Scanner;

public class compi11 {
	public static void main(String[] ar) {
		int pvp;
		float p, npvp, pr;
		Scanner teclado = new java.util.Scanner(System.in);

		System.out.print("Dame PVP: ");
		pvp = teclado.nextInt();
		teclado.close();

		p = (float) (pvp / 1.18);
		System.out.println("Precio ----------> " + p);
		pr = (float) (p - p * 0.25);
		System.out.println("Precio Rebajado--> " + pr);
		npvp = (float) (pr + pr * 0.18);
		System.out.println("Nuevo PVP -------> " + npvp);
	}
}