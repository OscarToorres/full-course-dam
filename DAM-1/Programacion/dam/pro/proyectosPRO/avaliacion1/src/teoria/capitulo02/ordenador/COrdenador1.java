package teoria.capitulo02.ordenador;

public class COrdenador1 {
	String Marca;
	String Procesador;
	String Pantalla;
	boolean OrdenadorEncendido;
	boolean Presentaci�n;

	void EncenderOrdenador() {
		if (OrdenadorEncendido == true) {
			System.out.println("======================================== ");
			System.out.println("El ordenador1 ya est� encendido.");
			System.out.println("======================================== ");
		} else {
			OrdenadorEncendido = true;
			System.out.println("======================================== ");
			System.out.println("El ordenador1 se ha encendido.");
			System.out.print("======================================== ");
		}
	}

	void Estado() {
		System.out.print("\nEstado del ordenador1:" + "\n- Marca: " + Marca + "\n- Procesador: " + Procesador
				+ "\n- Pantalla: " + Pantalla + "\n");
		if (OrdenadorEncendido == true)
			System.out.println("El ordenador1 est� encendido.");
		else
			System.out.println("El ordenador1 est� apagado");
	}

	public static void main(String[] args) {
		COrdenador1 MiOrdenador = new COrdenador1();
		MiOrdenador.Marca = "Ast";
		MiOrdenador.Procesador = "Intel Pentium";
		MiOrdenador.Pantalla = "TFT";
		MiOrdenador.EncenderOrdenador();
		MiOrdenador.Estado();
	}
}
