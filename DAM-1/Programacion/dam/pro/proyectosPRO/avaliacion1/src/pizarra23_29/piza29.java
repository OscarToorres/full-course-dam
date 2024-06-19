package pizarra23_29;

import java.util.Scanner;

public class piza29 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int i, j;

		for (i = 3; i <= 8; i++) {
			System.out.println("Multiplos del " + i + " entre el 20 y el 50");
			for (j = 20; j <= 50; j++) {
				if (j % i == 0)
					System.out.println(j);
			}
			teclado.nextLine();
		}
	}
}