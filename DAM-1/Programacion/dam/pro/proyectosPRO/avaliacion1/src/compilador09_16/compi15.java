package compilador09_16;

import java.util.Scanner;

public class compi15 {
	public static void main(String[] ar){
		int n1, n2, n3;
		Scanner teclado = new java.util.Scanner(System.in);
		
		System.out.print("Dame primer valor: ");
		n1 = teclado.nextInt();
		System.out.print("Dame segundo valor: ");
		n2 = teclado.nextInt();
		System.out.print("Dame tercer valor: ");
		n3 = teclado.nextInt();
		teclado.close();
		
		if (n1>n2) {
			if (n1>n3) {
				System.out.println("El MAYOR ---> " + n1);
			} else {
				System.out.println("El MAYOR ---> " + n3);
			}
		} else if (n2>n3) {
			System.out.println("El MAYOR ---> " + n2);	
		} else {
			System.out.println("El MAYOR ---> " + n3);
		}		
	}
}