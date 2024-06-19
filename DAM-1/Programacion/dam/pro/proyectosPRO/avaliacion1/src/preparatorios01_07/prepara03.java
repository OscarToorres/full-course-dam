package preparatorios01_07;

import java.io.IOException;

public class prepara03 {

	public static void main(String[] args) throws IOException {
		char letra;
		
		System.out.print("Dame CONSTANTE minuscula: ");
		letra = (char) System.in.read();
		System.in.read();
		System.in.read();
		
		while (letra >= 'b' && letra <= 'z' && letra != 'e' && letra != 'i' && letra != 'o' && letra != 'u') {
			System.out.println("-> Correcto, pulsaches esta CONSONANTE miniscula: " + letra);
			System.out.print("Dame CONSTANTE minuscula: ");
			letra = (char) System.in.read();
			System.in.read();
			System.in.read();
			
		}
		System.out.println("+++++> INCORRECTO, pulsaches esta techa: " + letra);
	}
}