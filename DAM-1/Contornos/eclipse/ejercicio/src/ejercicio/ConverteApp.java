package ejercicio;

public class ConverteApp {

	public static void main(String[] args) {

		final double valorRublo = 0.0095;
		final double valorEuro = 113.9670;
		final double cantidade = 100;

		int opcion = 0;
		Unit unit = new Unit(valorRublo, valorEuro, cantidade);
		Converter converter = new Converter(unit, opcion);
		double esperado = cantidade * valorEuro;

		if (esperado == converter.convert()) 
			System.out.println("Proba correcta");
		else
			System.out.println("Proba erronea");
	}

}