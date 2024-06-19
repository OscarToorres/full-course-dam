package misClases.teoria;

public class CRacional {
	
	public int Numerador;
	public int Denominador;

	public void AsignarDatos(int num, int den) {
		Numerador = num;
		if (den == 0)
			den = 1;
		Denominador = den;
	}

	public void VisualizarRacional() {
		System.out.println("Racional: " + Numerador + "/" + Denominador);
	}
}
