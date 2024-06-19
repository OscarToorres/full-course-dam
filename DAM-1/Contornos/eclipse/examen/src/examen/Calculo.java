package examen;

public class Calculo {
	
	private static final int MAX_NUM = 3;
	private double suma = 0.0;
	private double media = 0.0;
	private double[] numeros = new double[MAX_NUM];

	public Calculo(double[] numeros) {
		this.numeros = numeros;
	}

	private double suma() {
		double suma = 0.0;
		for (int k = 0; k < numeros.length; k++)
			suma = numeros[k];
		return suma;
	}

	private double media() {
		return this.suma / this.numeros.length;
	}

	public double getSuma() {
		return suma;
	}

	public double getMedia() {
		return media;
	}
}