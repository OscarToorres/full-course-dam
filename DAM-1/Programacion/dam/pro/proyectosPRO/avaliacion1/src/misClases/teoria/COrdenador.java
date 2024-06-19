package misClases.teoria;

import java.util.Scanner;

public class COrdenador {
	public String Marca;
	public String Procesador;
	public String Pantalla;
	public boolean OrdenadorEncendido;
	public boolean Presentación;

	public void EncenderOrdenador() {
		if (OrdenadorEncendido == true) {
			System.out.println("======================================== ");
			System.out.println("El ordenador ya está encendido.");
			System.out.println("======================================== ");
		} else {
			OrdenadorEncendido = true;
			System.out.println("======================================== ");
			System.out.println("El ordenador se ha encendido.");
			System.out.print("======================================== ");
		}
	}

	public void Estado() {
		System.out.print("\nEstado del ordenador:" + "\n- Marca: " + Marca + "\n- Procesador: " + Procesador
				+ "\n- Pantalla: " + Pantalla + "\n");
		if (OrdenadorEncendido == true) {
			System.out.println("El ordenador está encendido.");
		} else
			System.out.println("El ordenador está apagado");
	}
	
	public void ApagarOrdenador() {
		if (OrdenadorEncendido == true) {
			OrdenadorEncendido = false;
			System.out.println("======================================== ");
			System.out.println("El ordenador se ha apagado.");
			System.out.print("======================================== ");
		}else {
			System.out.println("======================================== ");
			System.out.println("El ordenador ya está apagado.");
			System.out.print("======================================== ");
		}
	}

	public void Modificar() {
		System.out.println();
		System.out.println("    TRAS LLAMAR AL METODO MODIFICA ");
		System.out.println("    ****************************** ");
		System.out.print("======================================== ");
		Scanner teclado = new java.util.Scanner(System.in);
		Marca = "DELL";
		Procesador = "AMD";
		Pantalla = "CRT";
		teclado.close();
		System.out.print("\nEstado del ordenador:" + "\n- Marca: " + Marca + "\n- Procesador: " + Procesador
				+ "\n- Pantalla: " + Pantalla + "\n");
		if (OrdenadorEncendido == true) {
			System.out.println("El ordenador está encendido.");
			System.out.println("======================================== ");
		} else
			System.out.print("El ordenador está apagado");
	}
}