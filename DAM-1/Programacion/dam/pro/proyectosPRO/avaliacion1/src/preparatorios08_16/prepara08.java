package preparatorios08_16;

import java.util.Scanner;

public class prepara08 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int edad;
		int edad25_35 = 0, edad30_45 = 0, edad40_60 = 0;

		System.out.print("Dame edad: ");
		edad = teclado.nextInt();

		while (edad >= 25 && edad <= 60) {
			if (edad >= 25 && edad < 30) {
				edad25_35++;
				System.out.println("CORRECTO, edad pulsada: " + edad + " -> modificado este intervalo: (25,35)");
			} else if (edad >= 30 && edad <= 35) {
				edad25_35++;
				edad30_45++;
				System.out.println("CORRECTO, edad pulsada: " + edad + " -> modificado este intervalo: (25,35) (30,45)");
			} else if (edad > 35 && edad < 40) {
				edad30_45++;
				System.out.println("CORRECTO, edad pulsada: " + edad + " -> modificado este intervalo: (30,45) (40,60)");
			} else if (edad >= 40 && edad < 45) {
				edad30_45++;
				edad40_60++;
				System.out.println("CORRECTO, edad pulsada: " + edad + " -> modificado este intervalo: (30,45) (40,60)");
			}else {
				edad40_60++;
				System.out.println("CORRECTO, edad pulsada: " + edad + " -> modificado este intervalo: (40,60)");
			}
			System.out.print("Dame edad: ");
			edad = teclado.nextInt();
		}
		System.out.println("+++++> Entre 25 e 35 pulsaronse " + edad25_35 + " edades");
		System.out.println("+++++> Entre 30 e 45 pulsaronse " + edad30_45 + " edades");
		System.out.println("+++++> Entre 40 e 60 pulsaronse " + edad40_60 + " edades");
		teclado.close();
	}
}

