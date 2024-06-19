package preparatorios01_07;

import java.io.IOException;

public class prepara04 {

	public static void main(String[] args) throws IOException {
		char letra;
		
		System.out.print("Dame CONSTANTE minuscula: ");
		letra = (char) System.in.read();
		System.in.read();
		System.in.read();
		
		while (letra < 'b' || letra > 'z' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
			System.out.println("-> INCORRECTO, pulsaches esta techa: " + letra);
			System.out.print("Dame CONSTANTE minuscula: ");
			letra = (char) System.in.read();
			System.in.read();
			System.in.read();
			
		}
		System.out.println("+++++> CORRECTO, pulsaches esta CONSONANTE minuscula: " + letra);
	}
}