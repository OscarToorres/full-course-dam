package compilador26_34;

import java.util.Scanner;

public class compi34 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int num = 0;
		int i = 0;
		int negativo = 0;
		int positivo = 0;
		int multiplos5 = 0;
		int sumaPar = 0;
		
		System.out.println();
		
		while (i < 8) {
			System.out.print("Ingrese valor " + (i + 1) + ": ");
			num = teclado.nextInt();
			if(num % 2 == 0)
				sumaPar = num + sumaPar;
			if(num >= 0)
				positivo++;
			else 
				negativo++;
			if (num % 5 == 0)
				multiplos5++;
			
			i++;
			}
		teclado.close();
		
		System.out.println("Cantidad de valores negativos: " + negativo);
		System.out.println("Cantidad de valores positivos: " + positivo);
		System.out.println("Cantidad de valores multiplos de 5: " + multiplos5);
		System.out.println("Suma de los valores pares: " + sumaPar);
		
	}
}


