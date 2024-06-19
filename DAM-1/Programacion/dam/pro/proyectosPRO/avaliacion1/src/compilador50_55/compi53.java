package compilador50_55;

import java.util.Scanner;

public class compi53 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int  numero;
		
		do {
			System.out.println("\n  M E N U");
			System.out.println("  =======");
			System.out.println(" 1.- Amoso UNHA");
			System.out.println(" 2.- Amoso DUAS DUAS");
			System.out.println(" 3.- Amoso TRES TRES TRES");
			numero = teclado.nextInt();
			switch (numero) {
				case 1:
					System.out.println("UNHA");
					break;
				case 2:
					System.out.println("DUAS DUAS");
					break;
				case 3:
					System.out.println("TRES TRES TRES");
					break;
			}
		} while (numero >= 0 && numero <= 3);
		System.out.println("FINAL");
		teclado.close();
	}
}