package preparatorios.ejem02;

public class CLibreria {
	private CLibro[] libreria;
	private int total;

	public CLibreria() {
		libreria = new CLibro[5];
		total = 0;
	}

	public void llenar() {
		libreria[0] = new CLibro(100, "La Celestina", 35.95F);
		libreria[1] = new CLibro(200, "El Quijote", 45.75F);
		libreria[2] = new CLibro(300, "La Biblia", 38.25F);
		libreria[3] = new CLibro(400, "El Barroco", 29.85F);
		libreria[4] = new CLibro(500, "La Colmena", 26.15F);
		total = 5;
	}

	public void vaciar() {
		total = 0;
	}

	public CLibro dameLibro(int cod) {
		int i;

		i = 0;
		while (i < total)
			if (libreria[i].getCodigo() == cod)
				return libreria[i];
			else
				i++;
		return null;

	}

	private int dameIndice(int cod) {
		int i;

		i = 0;
		while (i < total)
			if (libreria[i].getCodigo() == cod)
				return i;
			else
				i++;
		return -1;
	}

	private void elimina(int i) {
		while (i < total - 1) {
			libreria[i] = libreria[i + 1];
			i++;
		}
		total--;
	}

	public void eliminarLibro(int codigo) {
		int indice;

		indice = dameIndice(codigo);
		if (indice == -1)
			System.out.println("Libro no ENCONTRADO");
		else {
			elimina(indice);
			System.out.println("Libro ELIMINADO");

		}
	}

	public void mostrarLibro(int cod) {
		CLibro libro;

		libro = dameLibro(cod);
		if (libro == null)
			System.out.println("Libro no ENCONTRADO");
		else {
			mostrarCabecera();
			libro.mostrar();
		}
	}

	public void mostrar() {
		int i;

		if (total == 0)
			System.out.println("Libreria VACIA");
		else {
			mostrarCabecera();
			for (i = 0; i < total; i++)
				libreria[i].mostrar();
		}
	}

	private void mostrarCabecera() {
		System.out.println("CODIGO" + "\tTITULO  " + "\tPRECIO");
		System.out.println("======" + "\t======  " + "\t======");
	}

	private void menu() {
		System.out.println("\n  M E N U - 2");
		System.out.println("  ===========");
		System.out.println("1.- LLENAR libreria");
		System.out.println("2.- VACIAR libreria");
		System.out.println("3.- MOSTRAR libreria");
		System.out.println("4.- MOSTRAR libro");
		System.out.println("5.- ELIMINAR libro");
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
