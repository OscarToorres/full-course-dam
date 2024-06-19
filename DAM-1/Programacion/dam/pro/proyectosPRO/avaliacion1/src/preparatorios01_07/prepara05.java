package preparatorios01_07;

import java.util.Scanner;

public class prepara05 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int edad;
		int conta3_17 = 0, conta9_12 = 0, conta25_65 = 0, conta35_40 = 0; //contadores

		System.out.print("Dame EDAD: ");
		edad = teclado.nextInt();

		while (edad >= 3 && edad <= 17 || edad >= 25 && edad <= 65) {
			System.out.print("CORRECTO, edad pulsada: " + edad );
			if (edad >= 3 && edad < 17) {
				conta3_17++;
				if (edad >= 9 && edad <= 12) {
					conta9_12++;
					System.out.println("-> modificado este intervalo: (3,17) (9,12)");
				}else 
					System.out.println("-> modificado este intervalo: (3,17)");
			}
			if (edad >= 25 && edad <= 65) {
				conta25_65++;
				if(edad >= 35 && edad <= 40) {
					conta35_40++;
					System.out.println("-> modificado este intervalo: (25,65) (35,40)");
				}else
					System.out.println("-> modificado este intervalo: (25,65)");
			}
			System.out.print("Dame EDAD: ");
			edad = teclado.nextInt();
		}
		System.out.println("+++++> Entre 3 e 17 pulsaronse " + conta3_17 + " edades");
		System.out.println("+++++> Entre 9 e 12 pulsaronse " + conta9_12 + " edades");
		System.out.println("+++++> Entre 25 e 65 pulsaronse " + conta25_65 + " edades");
		System.out.println("+++++> Entre 35 e 40 pulsaronse " + conta35_40 + " edades");
		teclado.close();
	}	
}
