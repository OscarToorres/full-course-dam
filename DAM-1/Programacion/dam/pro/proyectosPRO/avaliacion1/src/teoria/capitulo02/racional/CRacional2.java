package teoria.capitulo02.racional;

public class CRacional2 {
	int Numerador;
	int Denominador;

	void AsignarDatos(int num, int den) {
		Numerador = num;
		if (den == 0)
			den = 1;
		Denominador = den;
	}

	void VisualizarRacional() {
		System.out.println("Racional-2: " + Numerador + "/" + Denominador);
	}
}
