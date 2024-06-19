package preparatorios08_16;

import java.io.IOException;

public class prepara11 {

	public static void main(String[] args) throws IOException {
		char caracter;

		System.out.print("Dame DIGITO o VOCAL minuscula: ");
		caracter = (char) System.in.read();
		System.in.read();
		System.in.read();

		while (caracter >= '0' && caracter <= '9' || caracter == 'a' || caracter == 'e' || caracter == 'i'
				|| caracter == 'o' || caracter == 'u') {
			if (caracter == 'a' || caracter == 'e' || caracter == 'i'|| caracter == 'o' || caracter == 'u') {
				System.out.println("-> CORRECTO, pulsaches esta VOCAL minuscula: " + caracter);
			}else
				System.out.println("-> CORRECTO, pulsaches este DIXITO: " + caracter);
			System.out.print("Dame DIGITO o VOCAL minuscula: ");
			caracter = (char)System.in.read();
			System.in.read();
			System.in.read();
		}
		System.out.println("+++++> INCORRECTO, pulsaches esta techa: " + caracter);
	}

}
