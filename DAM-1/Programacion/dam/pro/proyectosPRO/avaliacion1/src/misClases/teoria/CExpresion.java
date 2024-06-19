package misClases.teoria;

public class CExpresion {

	private double a, b, c;

	public void AsignaDatos(double aa, double bb, double cc) {
		a = aa;
		b = bb;
		c = cc;
	}

	public void VisualizarResultado() {
		double resultado;
		resultado = ((b * b) - 4 * a * c) / (2 * a);
		System.out.println(resultado);
	}
}
