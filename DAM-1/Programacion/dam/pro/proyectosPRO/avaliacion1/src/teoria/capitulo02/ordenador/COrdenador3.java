package teoria.capitulo02.ordenador;

public class COrdenador3 {
	String Marca;
	String Procesador;
	String Pantalla;
	boolean OrdenadorEncendido;
	boolean Presentación;

	void EncenderOrdenador() {
		if (OrdenadorEncendido == true) {
			System.out.println("======================================== ");
			System.out.println("El ordenador3 ya está encendido.");
			System.out.println("======================================== ");
		} else {
			OrdenadorEncendido = true;
			System.out.println("======================================== ");
			System.out.println("El ordenador3 se ha encendido.");
			System.out.print("======================================== ");
		}
	}

	void Estado() {
		System.out.print("\nEstado del ordenador3:" + "\n- Marca: " + Marca + "\n- Procesador: " + Procesador
				+ "\n- Pantalla: " + Pantalla + "\n");
		if (OrdenadorEncendido == true) {
			System.out.println("El ordenador3 está encendido.");
		} else
			System.out.print("El ordenador3 está apagado");
	}
	
	void ApagarOrdenador() {
		if (OrdenadorEncendido == true) {
			OrdenadorEncendido = false;
			System.out.println("======================================== ");
			System.out.println("El ordenador3 se ha apagado.");
			System.out.print("======================================== ");
		}else {
			System.out.println("======================================== ");
			System.out.println("El ordenador ya está apagado.");
			System.out.print("======================================== ");
		}
	}
}