package compilador209_211;

import misClases.avaliacion2.CArraysCadenas;

public class compi209 {

	public static void main(String[] args) {
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
				System.out.println("Opcion NO Implementada");
				break;
			case 4:
				System.out.println("Opcion NO Implementada");
				break;
			case 5:
				System.out.println("FINAL");
				break;
			default:
				System.out.println("OPCION Erronea");
				break;
			}
		} while (opcion != 5);
	}
}
