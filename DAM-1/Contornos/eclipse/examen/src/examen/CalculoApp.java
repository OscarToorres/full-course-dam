package examen;

public class CalculoApp {

	public static void main(String[] args) {

		double[] numeros = new double[] {1, 2, 3, 4};
		Calculo calculo = new Calculo(numeros);
		
		calculo.getMedia();
	}

}
