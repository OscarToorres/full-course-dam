package pizarra15_22;

import java.io.IOException;

public class piza21 {

	public static void main(String[] args) throws IOException {
		char letra;

		System.out.print("Pulse una tecla: ");
		letra = (char) System.in.read();

		if (letra >= 'A' && letra <= 'Z' || letra == 'Ñ') {
			System.out.println("MAYUSCULA: " + letra);
		} else if (letra >= 'a' && letra <= 'z' || letra == 'ñ') {
			System.out.println("MINUSCULA: " + letra);
		} else if (letra >= '0' && letra <= '9') {
			System.out.println("DIGITO: " + letra);
		} else {
			System.out.println("tecla NO PERMITIDA: " + letra);
		}
	}
}