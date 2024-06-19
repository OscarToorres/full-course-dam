package teoria.capitulo02.ordenador;

import misClases.teoria.COrdenador;

public class CApOrdenador {

	public static void main(String[] args) {
		COrdenador MiOrdenador = new COrdenador();
		MiOrdenador.Marca = "Ast";
		MiOrdenador.Procesador = "Intel Pentium";
		MiOrdenador.Pantalla = "TFT";
		MiOrdenador.EncenderOrdenador();
		MiOrdenador.Estado();
		MiOrdenador.ApagarOrdenador();
		MiOrdenador.Estado();
		MiOrdenador.Modificar();
	}

}
