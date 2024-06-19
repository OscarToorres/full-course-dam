package pizarra30_36;

import java.io.IOException;

public class piza34 {

	public static void main(String[] args) throws IOException {
		char letra;

		System.out.print("Dame MINUSCULA: ");
		letra = (char) System.in.read();
		System.in.read();
		System.in.read();

		while (letra >= 'a' && letra <= 'z') {
			System.out.println("Correcto es MINUSCULA: " + letra);
			System.out.print("Dame MINUSCULA: ");
			letra = (char) System.in.read();
			System.in.read();
			System.in.read();
		}
		System.out.println("INCORRECTO no es minuscula: " + letra);
	}

}