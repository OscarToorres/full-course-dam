package compilador17_25;

import java.util.Scanner;

public class compi22 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		
		float promedio = 0;
		int numAlumnos;
		float alturas = 0;
		int i = 1;
		
		System.out.print("Cuantos alumnos hay: ");
		numAlumnos = teclado.nextInt();
		
		while (numAlumnos >= i) {
			System.out.print("Dame altura " + i + ": ");
			alturas = teclado.nextFloat();
			promedio = alturas + promedio;
			i++;
		}
		
		teclado.close();
		System.out.println("Altura promedio: " + promedio);

	}
}
		
		/*
		// Esto indica el numero de personas iniciales
		int numPers;

		// Lo vamos a utilizar como un acumulador de datos, hasta alcanzar el numero que
		// introduzca el usuario
		float alt = 0;

		// Para calcular por ultimo la media de todas las alt
		float media;

		// la vamos usar como un contador para hacer el while hasta el numero que nos
		// interese, en este caso el
		// que nos indique el usuario
		int i = 0;

		Scanner teclado = new java.util.Scanner(System.in);

		System.out.println("\nCuantos alumnos hay: ");
		numPers = teclado.nextInt();

		while (i < numPers) {
			System.out.println("Dame la altura " + (i + 1));
			// Haciendo esto, vamos sumando todas las alturas que estan introducioendo para
			// asi tener un valor único a la hora de calcular la media
			alt = alt + teclado.nextFloat();
			// El ++ se usa para sumarle uno a una variable que es igual que poner i = i + 1
			i++;
		}

		teclado.close();
		media = alt / numPers;
		System.out.println("Altura promedia: " + media);
	}
	*/
		

