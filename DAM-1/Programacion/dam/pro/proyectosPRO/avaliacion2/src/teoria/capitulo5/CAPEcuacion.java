package teoria.capitulo5;

import misClases.teoria.CEcuacion;

public class CAPEcuacion {

	public static void main(final String[] args) {
		final CEcuacion ecuacion = new CEcuacion();
		ecuacion.recogeDatos();
		if (ecuacion.raicesComplejas()) {
			System.out.println("Las raices son complejas.");
		} else {
			ecuacion.muestraResultado();
		}
	}
}
