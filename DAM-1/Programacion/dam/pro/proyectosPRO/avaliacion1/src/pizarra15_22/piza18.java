package pizarra15_22;

import java.io.IOException;

public class piza18 {
	
	public static void main(String[] args) throws IOException {
		char letra;
		
		System.out.println("Pulse unha tecla Minuscula: ");
		letra = (char) System.in.read();
		
		if (letra >= 'a' && letra <= 'z') {
			System.out.println("Se pulso esta tecla: " + letra);
			System.out.println("Es MINUSCULA");
		}else {
			System.out.println("Tecla NO PERMITIDA: " + letra);
		}
	}	
}








/*
 Esta es una manera de hacerlo, pero no se puede aplicar en el examen
 
import java.util.Scanner;

public class piza18 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("\nIngrese una letra: ");
		char letra = teclado.nextLine().charAt(0);
		teclado.close();

		// Los tipos character sirven para saber con que tipo de caracter estamos
		// trabajando y de esta manera, en este caso, saber si la letra es una mayuscula
		// o si es una minuscula. Tambien los hay para poder saber si es un numero o
		// otras cosas.

		if (Character.isUpperCase(letra)) {
			System.out.println("Se pulso esta tecla: " + letra);
			System.out.println("MAYUSCULA");

		} else if (Character.isLowerCase(letra)) {
			System.out.println("Se pulso esta tecla: " + letra);
			System.out.println("MINUSCULA");

		} else {
			System.out.println("Tecla NO PERMITIDA: " + letra);
		}
	}
}
*/