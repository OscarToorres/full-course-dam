package examePractico;

import java.io.IOException;

public class prueba {

	public static void main(String[] args) throws IOException {
		char caracter;
		
		System.out.print("Dame un DÍXITO ou OPERADOR: ");
		caracter = (char) System.in.read();
		System.in.read();
		System.in.read();
		
		while ((caracter < '0' || caracter > '9') && caracter != '+') { 
			System.out.println("-> INCORRECTO, pulsaches esta tecla: " + caracter);
			System.out.print("Dame un DÍXITO ou OPERADOR: ");
			caracter = (char) System.in.read();
			System.in.read();
			System.in.read();
		}
		
		if (caracter == '+' ||caracter == '-' || caracter == '+' || caracter == '/')
			System.out.println("+++++> CORRECTO, pulsaches este OPERADOR: " + caracter);
		else 
			System.out.println("+++++> CORRECTO, pulsaches este DÍXITO: " + caracter);
	}
}
