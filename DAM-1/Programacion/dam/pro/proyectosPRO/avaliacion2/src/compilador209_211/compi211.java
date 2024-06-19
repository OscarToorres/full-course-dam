package compilador209_211;

import java.util.Scanner;

import misClases.avaliacion2.CArraysCadenas;

public class compi211 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int opcion;
		CArraysCadenas cadena = new CArraysCadenas();

		do {
			opcion = cadena.menu();

			switch (opcion) {
			case 1:
				cadena.inicializa();
				System.out.print("Array INICIALIZADO");
				break;
			case 2:
				cadena.amosa();
				break;
			case 3:
				cadena.ordenaAscendente();
				cadena.amosa();
				break;
			case 4:
				cadena.ordenaDescendente();
				cadena.amosa();
				break;
			case 5:
				System.out.println("FINAL");
				break;
			default:
				System.out.println("OPCION Erronea");
				break;
			}
		} while (opcion != 5);

		teclado.close();
	}
}
