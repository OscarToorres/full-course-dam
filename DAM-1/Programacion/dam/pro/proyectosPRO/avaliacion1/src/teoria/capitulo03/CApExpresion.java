package teoria.capitulo03;

import misClases.teoria.CExpresion;

public class CApExpresion {

	public static void main(String[] args) {
		CExpresion ex1 = new CExpresion();

		ex1.AsignaDatos(1, 5, 2);
		ex1.VisualizarResultado();
		ex1.AsignaDatos(3, 4, 2);
		ex1.VisualizarResultado();
		ex1.AsignaDatos(5, 3, 2);
		ex1.VisualizarResultado();
	}
}