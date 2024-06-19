package pizarra30_36;

import java.io.IOException;
//import java.util.Scanner;

public class piza33 {

	public static void main(String[] args) throws IOException {
		char letra;
		// Scanner teclado = new java.util.Scanner(System.in);

		System.out.print("Dame MINUSCULA: ");
		letra = (char) System.in.read();
		// Son dos maneras diferentes de saltar el intro a la hora de 
		//leer la letra que se intruduce
		// teclado.nextLine();
		System.in.read();
		System.in.read();

		// Manera de hacer la negacion de a && b
		while (letra < 'a' || letra > 'z') {
			System.out.print("Dame MINUSCULA: ");
			letra = (char) System.in.read();
			System.in.read();
			System.in.read();
			// teclado.nextLine();
		}
		System.out.println("FINAL");
		// teclado.close();
	}

}