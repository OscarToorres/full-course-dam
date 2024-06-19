package compilador35_40;

import java.util.Scanner;

import misClases.avaliacion1.CSerie;

public class compi39 {

	public static void main(String[] args) {
		
		CSerie serie = new CSerie();
		Scanner teclado = new Scanner(System.in);
		int i;
		int i2;
		
		System.out.println("El numero A será menor que el numero B");
		System.out.print("Dame el numero A: ");
		i = teclado.nextInt();
		System.out.print("Dame el numero B: ");
		i2 = teclado.nextInt();
		serie.MuestraA_B(i, i2);
		teclado.close();
	}
}