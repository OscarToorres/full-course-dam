package probaPractica;

import misClases.avaliacion3.CTiendaFruta;
import misClases.utilidades.Leer;

public class proba {
	public static void main(String[] args) {
		CTiendaFruta tiendaFrutas;
		tiendaFrutas = new CTiendaFruta();
		int numero;
		String codigo;
		do {
			numero = CTiendaFruta.dameOpcion();
			switch (numero) {
			case 1:
				tiendaFrutas.llenar();
				System.out.println("Tienda LLENA");
				break;
			case 2:
				tiendaFrutas.vaciar();
				System.out.println("Tienda VACIA");
				break;
			case 3:
				tiendaFrutas.mostrar();
				break;
			case 4:
				System.out.print("Dame código de fruta: ");
				codigo = Leer.datoString();
				tiendaFrutas.mostrar(codigo);
				break;
			case 5:
				System.out.println("FINAL");
				break;
			default:
				System.out.println("OPCION Erronea");
				break;
			}
		} while (numero != 5);
	}
}