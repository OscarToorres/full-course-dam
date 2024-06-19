package compilador26_34;

import java.util.Scanner;

public class compi30 {

	public static void main(String[] args) {
		
		Scanner teclado = new java.util.Scanner(System.in);
		int lista1; 
		int lista2;
		int total1 = 0;
		int total2 = 0;
		int i = 0;

		System.out.println("PRIMERA Lista");

		while (i < 4) {
			System.out.print("Dame valor " + (i + 1) + ": ");
			lista1 = teclado.nextInt();
			total1 = total1 + lista1;
			i++;
		}
		System.out.println();
		System.out.println("SEGUNDA Lista");

		i = 0;
		while (i < 4) {
			System.out.print("Dame valor " + (i + 1) + ": ");
			lista2 = teclado.nextInt();
			total2 = total2 + lista2;
			i++;
		}
		teclado.close();

		System.out.println("");
		System.out.println("TOTAL Lista 1: " + total1);
		System.out.println("TOTAL Lista 2: " + total2);

		if (total1 < total2) {
			System.out.println("Lista 2 MAYOR");
		} else if (total1 > total2) {
			System.out.println("Lista 1 MAYOR");
		} else {
			System.out.println("Listas IGUALES");
		}
		
	}
}
		
/*
		Scanner teclado = new java.util.Scanner(System.in);
		int[] lista1 = new int[4];
		int[] lista2 = new int[4];
		int total1 = 0;
		int total2 = 0;
		int i = 0;

		System.out.println("PRIMERA Lista");

		while (i < 4) {
			System.out.print("Dame valor " + (i + 1) + ": ");
			lista1[i] = teclado.nextInt();
			i++;
		}
		System.out.println();
		System.out.println("SEGUNDA Lista");

		i = 0;
		while (i < 4) {
			System.out.print("Dame valor " + (i + 1) + ": ");
			lista2[i] = teclado.nextInt();
			i++;
		}
		teclado.close();
		i = 0;
		while (i < 4) {
			total1 = lista1[i] + total1;
			i++;
		}
		i = 0;
		while (i < 4) {
			total2 = lista2[i] + total2;
			i++;
		}

		System.out.println("");
		System.out.println("TOTAL Lista 1: " + total1);
		System.out.println("TOTAL Lista 2: " + total2);

		if (total1 < total2) {
			System.out.println("Lista 2 MAYOR");
		} else if (total1 > total2) {
			System.out.println("Lista 1 MAYOR");
		} else {
			System.out.println("Listas IGUALES");
		}
		*/
