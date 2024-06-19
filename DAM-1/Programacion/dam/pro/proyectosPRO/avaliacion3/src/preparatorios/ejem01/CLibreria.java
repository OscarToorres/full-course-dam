package preparatorios.ejem01;

import java.util.ArrayList;
import java.util.Iterator;

public class CLibreria {
	private ArrayList<CLibro> libreria;

	public CLibreria() {
		libreria = new ArrayList<CLibro>();
	}

	public void llenar() {
		libreria.removeAll(libreria);
		libreria.add(new CLibro(100, "La Celestina", 35.95F));
		libreria.add(new CLibro(200, "El Quijote", 45.75F));
		libreria.add(new CLibro(300, "La Biblia", 38.25F));
		libreria.add(new CLibro(400, "El Barroco", 29.85F));
		libreria.add(new CLibro(500, "La Colmena", 26.15F));
	}

	public void vaciar() {
		libreria.removeAll(libreria);
	}

	private CLibro dameLibro(int cod) {
		Iterator<CLibro> iterator = libreria.iterator();
		CLibro libro;

		while (iterator.hasNext()) {
			libro = iterator.next();
			if (libro.getCodigo() == cod)
				return libro;
		}
		return null;
	}

	public void eliminarLibro(int codigo) {
		CLibro libro;

		libro = dameLibro(codigo);
		if (libro == null)
			System.out.println("libro no ENCONTRADO");
		else {
			libreria.remove(libro);
			System.out.println("libro ELIMINADO");

		}
	}

	public void mostrarLibro(int cod) {
		CLibro libro;

		libro = dameLibro(cod);
		if (libro == null)
			System.out.println("libro no ENCONTRADO");
		else {
			mostrarCabecera();
			libro.mostrar();
		}
	}

	private void mostrarDato(Iterator<CLibro> iterator) {
		CLibro libro;
		if (iterator.hasNext()) {
			libro = iterator.next();
			mostrarDato(iterator);
			libro.mostrar();
		}

	}

	public void mostrar() {
		Iterator<CLibro> iterator = libreria.iterator();

		if (libreria.isEmpty())
			System.out.println("libreria VACIA");
		else {
			mostrarCabecera();
			mostrarDato(iterator);
//			while (iterator.hasNext())
//				iterator.next().mostrar();
		}
	}

	private void mostrarCabecera() {
		System.out.println("CODIGO" + "\tTITULO  " + "\tPRECIO");
		System.out.println("======" + "\t======  " + "\t======");
	}

	private void menu() {
		System.out.println("\n  M E N U - 1");
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
