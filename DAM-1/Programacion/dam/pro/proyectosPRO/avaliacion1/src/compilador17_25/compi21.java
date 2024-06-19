package compilador17_25;

import java.util.Scanner;

public class compi21 {

	public static void main(String[] args) {
		
		Scanner teclado = new java.util.Scanner(System.in);
		int notas;
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < 7) {
			System.out.print("Dame nota " + (i + 1) + (": "));
			notas = teclado.nextInt();
			if (notas >= 6) 
				j++;
			 else 
				k++;
			
			i++;
		}
		teclado.close();
		System.out.println("Alumnos con nota mayor o igual que 6: " + j);
		System.out.println("Alumnos con nota menor que 6: " + k);
		
	}
}	




/*
		Scanner teclado = new java.util.Scanner(System.in);
		// Se denomina Array de datos, empiezan en el 0 hasta el limite que le pongas.
		int[] notas = new int[7];
		// i la usaremos como contandor para el bucle
		int i = 0;
		// j y k la usaremos como otro contador pero para la condicion
		int j = 0;
		int k = 0;
		while (i < 7) {
			System.out.println("Dame nota " + (i + 1));
			// Con notas[i] lo que aremoss era pasasr a la siguiente Array de datos para no
			// estar metiendo datos nuevos en el mismo sitio, sino no los estariamos
			// almacenando, sino substituyendo siempre el mismo dato
			notas[i] = teclado.nextInt();
			i++;
		}
		teclado.close();
		// en esta parte le damos el valor 0 a i otra vez para utilizarla como un nuevo
		// contandor sin necesidad de añadir nuevas variables
		i = 0;
		// Ahora crearemos un nuevo bucle con dos nuevas variables que las usaremos para
		// contar, de esta manera cuando se cumplan las condiciones se les ira sumando
		// una unidad y asi sabremos cuantos alumnos han pasado o igualado el seis y
		// cuantos no lo han hecho
		while (i < 7) {

			if (notas[i] >= 6) {
				j++;
			} else {
				k++;
			}
			i++;
			// Por ultimo imprimiremos en pantalla el resultado de nuestro estudio
		}
		System.out.println("Alumnos con nota mayor o igual que 6: " + j);
		System.out.println("Alumnos con nota menor que 6: " + k);

	}
}
*/