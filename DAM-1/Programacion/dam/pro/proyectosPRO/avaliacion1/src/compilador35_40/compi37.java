package compilador35_40;

import java.util.Scanner;

import misClases.avaliacion1.CSerie;

public class compi37 {

	public static void main(String[] args) {
		CSerie serie = new CSerie();
		Scanner teclado = new Scanner(System.in);
		int i;
		
		System.out.print("Dame un numero entre 1 y 20: ");
		i = teclado.nextInt();
		serie.MuestraHasta20(i);
		teclado.close();
	}
}