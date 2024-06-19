package exame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CHospital {
	private CPaciente[] hospital;
	private int total;
	private DataOutputStream flujoSalida;
	private DataInputStream flujoEntrada;
	private File fichero;

	public CHospital(File fich) {
		hospital = new CPaciente[10];
		total = 0;
		fichero = fich;
	}

	public void llenar() {
		hospital[0] = new CPaciente("P01", "Ignacio Arias", 25, 38.2F);
		hospital[1] = new CPaciente("P02", "Ana Menéndez", 39, 39.1F);
		hospital[2] = new CPaciente("P03", "Lucas García", 32, 38.6F);
		hospital[3] = new CPaciente("P04", "Mercedes Novoa", 18, 37.9F);
		hospital[4] = new CPaciente("P05", "María Argüelles", 15, 38.7F);
		total = 5;
	}

	public void vaciar() {
		total = 0;
	}

	public void salvar() {
		int i;
		if (total == 0)
			System.out.println("Hospital VACIO");
		else {
			flujoSalida = null;
			try {
				flujoSalida = new DataOutputStream(new FileOutputStream(fichero));
				for (i = 0; i < total; i++) {
					flujoSalida.writeUTF(hospital[i].getCodigo());
					flujoSalida.writeUTF(hospital[i].getNombre());
					flujoSalida.writeInt(hospital[i].getHabitacion());
					flujoSalida.writeFloat(hospital[i].getTemperatura());
				}
			} catch (IOException e) {
				System.out.println("problemas al SALVAR el fichero");

			} finally {
				if (flujoSalida != null)
					try {
						flujoSalida.close();
					} catch (IOException e) {
						System.out.println("problemas al CERRAR el flujo de salida");
					}
			}
		}
	}

	public void restaurar() {
		String codigo;
		String nombre;
		int habitacion;
		float temperatura;
		int i;
		flujoEntrada = null;
		i = 0;
		try {
			flujoEntrada = new DataInputStream(new FileInputStream(fichero));
			do {
				codigo = flujoEntrada.readUTF();
				nombre = flujoEntrada.readUTF();
				habitacion = flujoEntrada.readInt();
				temperatura = flujoEntrada.readFloat();
				hospital[i] = new CPaciente(codigo, nombre, habitacion, temperatura);
				i++;
			} while (true);
		} catch (EOFException e) {
			// no se hace nada
		} catch (IOException e) {
			System.out.println("problemas al RESTAURAR el fichero");
		} finally {
			if (flujoEntrada != null)
				try {
					flujoEntrada.close();
				} catch (IOException e) {
					System.out.println("problemas al CERRAR el flujo de entrada");
				}
		}
		total = i;
	}

	private CPaciente damePaciente(String cod) {
		int i;
		i = 0;
		while (i < total)
			if (hospital[i].getCodigo().equals(cod))
				return hospital[i];
			else
				i++;
		return null;
	}

	private int dameIndice(String cod) {
		int i;
		i = 0;
		while (i < total)
			if (hospital[i].getCodigo().equals(cod))
				return i;
			else
				i++;
		return -1;
	}

	private void elimina(int i) {
		while (i < total - 1) {
			hospital[i] = hospital[i + 1];
			i++;
		}
		total--;
	}

	public void eliminarPaciente(String codigo) {
		int indice;
		indice = dameIndice(codigo);
		if (indice == -1)
			System.out.println("Paciente no ENCONTRADO");
		else {
			elimina(indice);
			System.out.println("Paciente ELIMINADO");
		}
	}

	public void insertarPaciente() {
		String codigo;
		String nombre;
		int habitacion;
		float temperatura;
		System.out.print("Dame código: ");
		codigo = Leer.datoString();
		System.out.print("Dame nombre: ");
		nombre = Leer.datoString();
		System.out.print("Dame habitacion: ");
		habitacion = Leer.datoInt();
		System.out.print("Dame temperatura: ");
		temperatura = Leer.datoFloat();
		hospital[total] = new CPaciente(codigo, nombre, habitacion, temperatura);
		total++;
	}

	public void modificarPaciente(String codigo) {
		CPaciente paciente;
		float temperatura;
		paciente = damePaciente(codigo);
		if (paciente == null)
			System.out.println("Paciente no ENCONTRADO");
		else {
			System.out.println("Temperatura ACTUAL: " + paciente.getTemperatura());
			System.out.print("Dame temperatura NUEVA: ");
			temperatura = Leer.datoFloat();

			paciente.setTemperatura(temperatura);
			System.out.println("Paciente MODIFICADO");
		}
	}

	public void mostrarPaciente(String codigo) {
		CPaciente paciente;
		paciente = damePaciente(codigo);
		if (paciente == null)
			System.out.println("Paciente no ENCONTRADO");
		else {
			mostrarCabecera();
			paciente.mostrar();
		}
	}

	public void mostrar() {
		int i;
		if (total == 0)
			System.out.println("Hospital VACIO");
		else {
			mostrarCabecera();
			for (i = 0; i < total; i++)
				hospital[i].mostrar();
		}
	}

	private void mostrarCabecera() {
		System.out.println("CODIGO" + "\tNOMBRE " + "\t\tHABITACION" + "\tTEMPERATURA");
		System.out.println("======" + "\t====== " + "\t\t==========" + "\t===========");
	}

	private void menu() {
		System.out.println("\n M E N U - Exame");
		System.out.println(" ===============");
		System.out.println("1.- LLENAR Hospital");
		System.out.println("2.- VACIAR Hospital");
		System.out.println("3.- MOSTRAR Hospital");
		System.out.println("4.- MOSTRAR Paciente");
		System.out.println("5.- INSERTAR Paciente");
		System.out.println("6.- MODIFICAR Paciente");
		System.out.println("7.- ELIMINAR Paciente");
		System.out.println("8.- SALVAR Hospital en Fichero");
		System.out.println("9.- RESTAURAR Hospital desde Fichero");
		System.out.println("10.- FINAL");
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