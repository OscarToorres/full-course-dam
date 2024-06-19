package preparatorios.prepara02;

public class CFruteria {
	
	private CFruta[] fruteria;
	private int total;

	public CFruteria() {
		fruteria = new CFruta[5];
		total = 0;
	}

	
	public void llenarFruteria() {
		fruteria[0] = new CFruta("F01", "Aguacates", 52, 3.25F);
		fruteria[1] = new CFruta("F02", "Zanahorias", 34, 5.45F);
		fruteria[2] = new CFruta("F03", "Platanos", 57, 4.75F);
		fruteria[3] = new CFruta("F04", "Manzanas", 47, 2.85F);
		fruteria[4] = new CFruta("F05", "Mandarinas", 61, 3.55F);
		total = 5;
	}
	
	public void vaciar() {
		total = 0;
	}
	
	public CFruta dameFruta(String cod) {
		int i;

		i = 0;
		while (i < total)
			if (fruteria[i].getCodigo().equals(cod))
				return fruteria[i];
			else
				i++;
		return null;
	}
		
	public void mostrarFruta(String cod) {
		CFruta fruta;

		fruta = dameFruta(cod);
		if (fruta == null)
			System.out.println("Fruta no ENCONTRADA");
		else {
			mostrarCabecera();
			fruta.mostrar();
		}
	}
	
	private int dameIndice(String cod) {
		int i;

		i = 0;
		while (i < total)
			if (fruteria[i].getCodigo().equals(cod))
				return i;
			else
				i++;
		return -1; 
	}
	
	private void elimina(int i) {
		while (i < total - 1) {
			fruteria[i] = fruteria[i + 1];
			i++;
		}
		total--;
	}

	public void eliminarFruta(String codigo) {
		int indice;

		indice = dameIndice(codigo);
		if (indice == -1)
			System.out.println("Fruta no ENCONTRADA");
		else {
			elimina(indice);
			System.out.println("Fruta ELIMINADA");

		}
	}
	
	private void mostrarCabecera() {
		System.out.println("CODIGO" + "\tNOMBRE  " + "\tCANTIDAD" + "\tPRECIO");
		System.out.println("======" + "\t======  " + "\t========" + "\t======");
	}
	
	public void mostrar() {
		int i;

		if (total == 0)
			System.out.println("Fruteria VACIA");
		else {
			mostrarCabecera();
			for (i = 0; i < total; i++)
				fruteria[i].mostrar();
		}
	}

	private void menu() {
		System.out.println("\n  M E N U - 1");
		System.out.println("  ===========");
		System.out.println("1.- LLENAR fruteria");
		System.out.println("2.- VACIAR fruteria");
		System.out.println("3.- MOSTRAR fruteria");
		System.out.println("4.- MOSTRAR fruta");
		System.out.println("5.- ELIMINAR fruta");
		System.out.println("6.- FINAL");
		System.out.print("Pulsa opción: ");
	}

	public int dameOpcion() {
		int opcion;

		menu();
		opcion = Leer.datoInt();
		System.out.println();
		return opcion;
	}
}