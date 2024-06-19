package compilador01_08;

import java.util.Scanner;

public class compi05 {
	public static void main(String[] ar) {
		int i;
		Scanner teclado = new java.util.Scanner(System.in);

		System.out.print("Dame un numero del 1 al 10: ");
		i = teclado.nextInt();
		teclado.close();

		System.out.println("\nTabla del " + i);
		System.out.println("===========");
		System.out.println(i + " X 1 = " + i * 1);
		System.out.println(i + " X 2 = " + i * 2);
		System.out.println(i + " X 3 = " + i * 3);
		System.out.println(i + " X 4 = " + i * 4);
		System.out.println(i + " X 5 = " + i * 5);
		System.out.println(i + " X 6 = " + i * 6);
		System.out.println(i + " X 7 = " + i * 7);
		System.out.println(i + " X 8 = " + i * 8);
		System.out.println(i + " X 9 = " + i * 9);
	}

}