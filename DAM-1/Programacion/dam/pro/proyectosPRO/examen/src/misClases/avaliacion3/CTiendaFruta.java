package misClases.avaliacion3;

import misClases.utilidades.Leer;

public class CTiendaFruta {

	private CFruta[] tienda;

	public CTiendaFruta() {
		tienda = new CFruta[5];
	}

	public void llenar() {

		tienda[0] = new CFruta("F01", "Aguacates", 52, 3.25F);
		tienda[1] = new CFruta("F02", "Zanahorias", 34, 5.45F);
		tienda[2] = new CFruta("F03", "Platanos", 57, 4.75F);
		tienda[3] = new CFruta("F04", "Manzanas", 47, 2.85F);
		tienda[4] = new CFruta("F05", "Mandarinas", 61, 3.55F);
	}

	public void vaciar() {
		int i;
		for (i = 0; i < tienda.length; i++)
			tienda[i] = null;
	}

	public void mostrar() {
		int i;
		mostrarCabecera();
		for (i = 0; i < tienda.length; i++)
			if (tienda[i] != null)
				tienda[i].mostrar();
			else
				System.out.println(tienda[i]);
	}

	private void mostrarCabecera() {
		System.out.println("CODIGO" + "\t\tNOMBRE " + "\t\tCANTIDAD" + "\tPRECIO");
		System.out.println("======" + "\t\t====== " + "\t\t========" + "\t======");
	}

	public void mostrar(String cod) {
		int i;
		boolean encontrado, salir;
		i = 0;
		encontrado = false;
		salir = false;
		while (salir == false)
			if (i >= tienda.length)
				salir = true;
			else if (tienda[i] == null)
				salir = true;
			else if (tienda[i].getCodigo().equals(cod)) {
				mostrarCabecera();
				tienda[i].mostrar();
				encontrado = true;
				salir = true;
			} else
				i++;
		if (!encontrado)
			System.out.println("Fruta no ENCONTRADA");
	}

	private static void menu() {
		System.out.println("\n M E N U");
		System.out.println(" =======");
		System.out.println(" 1.- LLENAR tienda");
		System.out.println(" 2.- VACIAR tienda");
		System.out.println(" 3.- MOSTRAR tienda");
		System.out.println(" 4.- MOSTRAR fruta");
		System.out.println(" 5.- FINAL");
	}

	public static int dameOpcion() {
		int opcion;
		menu();
		opcion = Leer.datoInt();
		return opcion;
	}
}