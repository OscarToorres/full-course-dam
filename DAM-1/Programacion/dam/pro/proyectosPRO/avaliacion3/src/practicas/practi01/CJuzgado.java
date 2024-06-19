package practicas.practi01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CJuzgado {

	private Scanner scanner = new java.util.Scanner(System.in);
	private ArrayList<CProceso> juzgado;

	public CJuzgado() {
		juzgado = new ArrayList<CProceso>();
	}

	private void menu() {
		System.out.println("\n  M E N U - Práctica 1");
		System.out.println("  =====================");
		System.out.println("1.- LLENAR Juzgado");
		System.out.println("2.- VACIAR Juzgado");
		System.out.println("3.- MOSTRAR Juzgado");
		System.out.println("4.- INSERTAR Proceso");
		System.out.println("5.- MODIFICAR Proceso");
		System.out.println("6.- ELIMINAR Proceso");
		System.out.println("7.- FINAL");
		System.out.print("Pulsa opción: ");
	}

	public int dameOpcion() {
		int opcion;

		menu();
		opcion = Leer.datoInt();
		System.out.println();
		return opcion;
	}

	public void llenar() {
		juzgado.removeAll(juzgado);
		juzgado.add(new CProceso("P101", "Empresa ARA", 1230.5F));
		juzgado.add(new CProceso("P102", "Punto limpio", 2245.75F));
		juzgado.add(new CProceso("P103", "Divorcio Pedro", 538.25F));
		juzgado.add(new CProceso("P104", "Concesionario", 3429.5F));
		juzgado.add(new CProceso("P105", "Alquiler piso", 826.25F));
		juzgado.add(new CProceso("P106", "Punto limpio", 2245.75F));
	}

	public void vaciar() {
		juzgado.removeAll(juzgado);
	}

	public void mostrar() {
		Iterator<CProceso> iterator = juzgado.iterator();

		if (juzgado.isEmpty())
			System.out.println("Oposicion VACIA");
		else {
			mostrarCabecera();
			while (iterator.hasNext())
				iterator.next().mostrar();
		}
	}

	private void mostrarCabecera() {
		System.out.println("IDENTIFICADOR" + "\tTITULO  " + "\tARANCEL");
		System.out.println("=============" + "\t======  " + "\t=======");
	}

	public void insertarProceso() {
		System.out.print("Identificador: ");
		String identificador = scanner.next();
		System.out.print("Titulo: ");
		String titulo = scanner.next();
		System.out.print("Arancel: ");
		float arancel = scanner.nextFloat();
		while (arancel > '0' && arancel < '9') {
			System.out.print("Dato float INVALIDO. Telcee otro: ");
			arancel = scanner.nextFloat();
		}
		juzgado.add(new CProceso(identificador, titulo, arancel));

	}

	private int dameProceso(String ident) {

		for (int i = 0; i < juzgado.size(); i++) {
			if (juzgado.get(i).getIdentificador().equals(ident))
				return i;
		}

		return -1;
	}

	private int dameProcesoModificado(final int pro) {
		this.mostrarCabecera();
		juzgado.get(pro).mostrar();
		System.out.print("NUEVO identificador: ");
		juzgado.get(pro).setIdentificador(Leer.datoString());
		System.out.print("NUEVO titulo: ");
		juzgado.get(pro).setTitulo(Leer.datoString());
		System.out.print("NUEVO arancel: ");
		juzgado.get(pro).setArancel(Leer.datoFloat());
		return pro;
	}

	public void modificarProceso(final String ide) {
		int proceso = this.dameProceso(ide);
		if (proceso == -1) {
			System.out.println("Proceso no ENCONTRADO");
		} else {
			final int indice = this.juzgado.indexOf(juzgado.get(proceso));
			proceso = this.dameProcesoModificado(proceso);
			this.juzgado.set(indice, juzgado.get(proceso));
		}
	}

	public void eliminarProceso(String ident) {
		int titulo;

		titulo = dameProceso(ident);
		if (titulo == -1)
			System.out.println("Juez no ENCONTRADO");
		else {
			juzgado.remove(titulo);
			System.out.println("Juez ELIMINADO");
		}
	}
}
