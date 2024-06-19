package probaPractica;

import misClases.avaliacion3.CTiendaFruta;
import misClases.utilidades.Leer;

public class proba {
	
	public static void main(final String[] args) {
		 CTiendaFruta fruta;
		fruta = new CTiendaFruta();

		int opcion;
		do {
			opcion = fruta.dameOpcion();
			switch (opcion) {
			case 1: {
				fruta.llenar();
				System.out.println("Juzgado LLENO");
				continue;
			}
			case 2: {
				fruta.vaciar();
				System.out.println("Juzgado VACIO");
				continue;
			}
			case 3: {
				fruta.mostrar();
				continue;
			}
			case 4: {
				System.out.print("Dame identificador de proceso: ");
				final String identificador = Leer.datoString();
				fruta.modificarProceso(identificador);
				continue;
			}
			case 6: {
				System.out.print("Dame identificador de proceso: ");
				final String identificador = Leer.datoString();
				fruta.eliminarProceso(identificador);
				continue;
			}
			case 7: {
				System.out.println("FINAL");
				continue;
			}
			default: {
				System.out.println("OPCION Erronea");
				continue;
			}
			}
		} while (opcion != 7);
	}
}