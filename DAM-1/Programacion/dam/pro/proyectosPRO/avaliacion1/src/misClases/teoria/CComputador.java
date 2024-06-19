package misClases.teoria;

public class CComputador {

	private String Marca;
	private String Procesador;
	private String Pantalla;
	private static byte Garantia;
	private boolean ComputadorEncendido;
	
	public void AsignarMarca(String a) {
		Marca = a;
	}
	
	public void AsignarProcesador(String a) {
		Procesador = a;
	}
	
	public void AsignarPantalla(String a) {
		Pantalla = a;
	}
	
	public void AsignarGarantia(byte a) {
		Garantia = a;
	}
	
	public void EncenderComputador() {
		System.out.println("========================================");
		if (ComputadorEncendido == true) { // si el ordenador esta encencdido
			System.out.println("El Computador esta encendido.");
			System.out.println("");
		} else { // si no esta encendido encenderlo
			ComputadorEncendido = true;
			System.out.println("El Computador se ha encendido.");
		}
	}

	public void Estado() {
		System.out.println("========================================");
		System.out.println("Estado del Computador " + "\n-Marca: " + Marca + "\n-Procesador: " + Procesador
				+ "\n-Pantalla: " + Pantalla + "\n-Garantia: " + Garantia);

		if (ComputadorEncendido == true) // si el ordenador esta encendido
			System.out.println("*El Computador está encendido.");
		else // si no esta encendido
			System.out.println("*El Computador esta apagado.");
	}

	public void ApagarComputador() {
		System.out.println("");
		System.out.println("========================================");
		if (ComputadorEncendido == true) {
			System.out.println("El Computador se ha apagado.");
			ComputadorEncendido = false;
		}

	}
}