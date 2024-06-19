package preparatorios08_16;

import java.util.Scanner;

public class prepara13 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int edad, edad10_30 = 0, edad30_50 = 0, edad15_21 = 0, edad25_45 = 0;

		System.out.print("Dame una edad: ");
		edad = teclado.nextInt();

		while (edad >= 10 && edad <= 50) {
			if (edad >= 10 && edad < 15) {
				edad10_30++;
				System.out.println("CORRECTO, edad pulsada: 10  -> modificado este intervalo: (10,30)");
			} else if (edad >= 15 && edad <= 21) {
				edad10_30++;
				edad15_21++;
				System.out.println("CORRECTO, edad pulsada: 15  -> modificados estos intervalos: (10,30) (15,21)");
			} else if (edad > 21 && edad < 25) {
				edad10_30++;
				System.out.println("CORRECTO, edad pulsada: 25  -> modificados estos intervalos: (10,30) (25,45)");
			} else if (edad >= 25 && edad < 30) {
				edad10_30++; 
				edad25_45++;
				System.out.println("CORRECTO, edad pulsada: 30 -> modificados estos intervalos: (10,30) (25,45) ");
			}else if (edad == 30) {
				edad10_30++;
				edad30_50++;
				edad25_45++;
				System.out.println("CORRECTO, edad pulsada: 10  -> modificado este intervalo: (10,30) (25,45) (30,50)");
			}else if (edad >= 30 && edad <= 45) {
				edad30_50++;
				edad25_45++;
				System.out.println("CORRECTO, edad pulsada: 31  -> modificados estos intervalos: (25,45) (30,50)");
			} else {
				edad30_50++;
				System.out.println("CORRECTO, edad pulsada: 46  -> modificado este intervalo: (30,50)");
			}
			System.out.print("Dame una edad: ");
			edad = teclado.nextInt();
		}
		
		System.out.println("+++++> Entre 10 e 30 pulsaronse " + edad10_30 + " edades");
		System.out.println("+++++> Entre 30 e 50 pulsaronse " + edad30_50 + " edades");
		System.out.println("+++++> Entre 15 e 21 pulsaronse " + edad15_21 + " edades");
		System.out.println("+++++> Entre 25 e 45 pulsaronse " + edad25_45 + " edades");
		teclado.close();
	}
}