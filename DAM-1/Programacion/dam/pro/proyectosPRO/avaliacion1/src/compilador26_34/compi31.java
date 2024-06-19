package compilador26_34;

import java.util.Scanner;

public class compi31 {

	public static void main(String[] args) {
	
	Scanner teclado = new java.util.Scanner(System.in);
	int cantNum;
	int i = 0;
	int j = 0;
	int k = 0;	
	int num = 0;
	System.out.print("Cuantos numeros: ");
	cantNum = teclado.nextInt();


	while(i < cantNum) {
		System.out.print("Dame valor " + (i + 1) + (": "));
		num = teclado.nextInt();
		if(num % 2 == 0) {
			j++;
		}else {
			k++;
		}
		i++;
	}
	teclado.close();
	
	System.out.println("Cantidad de pares: " + j);
	System.out.println("Cantidad de impares: " + k);
	
	}
	
}
	




















		/*
		Scanner teclado = new java.util.Scanner(System.in);
		int cantNum;
		int i = 0;
		int j = 0;
		int k = 0;
		
		System.out.print("\nCuantos numeros: ");
		cantNum = teclado.nextInt();
		
		int[] num = new int[cantNum];
		
		while(i < cantNum) {
			System.out.print("Dame valor " + (i + 1) + (": "));
			num[i] = teclado.nextInt();
			i++;
		}
		teclado.close();
		i = 0;
		while(i < cantNum) {
			if(num[i] % 2 == 0) {
				j++;
			}else {
				k++;
			}
		i++;
		}
		System.out.println("Cantidad de pares: " + j);
		System.out.println("Cantidad de impares: " + k);
		*/
