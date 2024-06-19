package examePractico;

import java.util.Scanner;

public class pregunta1 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int edad;
		int edad40_60 = 0, edad50_75 = 0, edad60_90 = 0, edad80_85 = 0; // contadores

		System.out.print("Dame edad: ");
		edad = teclado.nextInt();

		while (edad >= 40 && edad <= 90) {
			System.out.print("CORRECTO, edad pulsada: " + edad);
			if (edad >= 40 && edad < 50) {
				edad40_60++;
				System.out.println(" -> modificados estos intervalos: (40,60)");
			}else if (edad >= 50 && edad < 60) {
				edad40_60++;
				edad50_75++;
				System.out.println("-> modificados estos intervalos: (40,60) (50,75)");
			}else if (edad == 60) {
				edad40_60++;
				edad50_75++;
				edad60_90++;
				System.out.println("-> modificados estos intervalos: (40,60) (50,75) (60,90)");
			}else if (edad > 60 && edad <= 75) {
				edad50_75++;
				edad60_90++;
				System.out.println("-> modificados estos intervalos: (50,75) (60,90)");
			}else if (edad > 75 && edad < 80) {
				edad60_90++;
				System.out.println("-> modificados estos intervalos: (60,90)");
			}else if (edad >= 80 && edad < 85) {
				edad60_90++;
				edad80_85++;
				System.out.println("-> modificados estos intervalos: (80,85) (60,90)");
			}else if (edad == 85 ) {
				edad60_90++;
				edad80_85++;
				System.out.println("-> modificados estos intervalos: (80,85) (60,90)");
			}else {
				edad60_90++;
				System.out.println("-> modificados estos intervalos: (60,90)");
			}
			System.out.print("Dame edad: ");
			edad = teclado.nextInt();
		}
		System.out.println("+++++> Entre 40 e 60 pulsaronse " + edad40_60 + " edades");
		System.out.println("+++++> Entre 50 e 75 pulsaronse " + edad50_75 + " edades");
		System.out.println("+++++> Entre 60 e 90 pulsaronse " + edad60_90 + " edades");
		System.out.println("+++++> Entre 80 e 85 pulsaronse " + edad80_85 + " edades");
		
		teclado.close();
	}
}
