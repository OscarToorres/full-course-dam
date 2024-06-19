package teoria.capitulo04;

import misClases.teoria.CComputador;

public class CApComputador {

	public static void main(String[] args) {
		CComputador MiComputador = new CComputador();

		MiComputador.AsignarMarca("Ast");
		MiComputador.AsignarProcesador("Intel Pentium");
		MiComputador.AsignarPantalla("TFT");
		MiComputador.AsignarGarantia((byte) 3);
		MiComputador.EncenderComputador();
		MiComputador.Estado();
		MiComputador.ApagarComputador();
		MiComputador.Estado();
		System.out.println("");
		MiComputador.AsignarMarca("HP");
		MiComputador.AsignarProcesador("AMD");
		MiComputador.AsignarPantalla("CRT");
		MiComputador.AsignarGarantia((byte) 3);
		MiComputador.EncenderComputador();
		MiComputador.Estado();
		MiComputador.ApagarComputador();
		MiComputador.Estado();
	}
}