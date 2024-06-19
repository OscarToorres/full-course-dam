package tarea3_11;

public class CalculoApp {

	public static void main(String[] args) {
		
		double[] valores = {1,1,1,1};
		
		//prueba de media
		Calculo calculo = new Calculo();
		calculo.inserirValores(valores);
		double esperado1 = (1 + 1 + 1 + 1) / 4;
		if(esperado1 == calculo.media()) 
			System.out.println("Prueba de media correcta");
		else
			System.out.println("Prueba de media erronea");
		
		//prueba de suma
		double  esperado2 = (double) 1 + 1 + 1 + 1;
		calculo.inserirValores(valores);
		if(esperado2 == calculo.sumar()) 
			System.out.println("Prueba de suma correcta");
		else
			System.out.println("Prueba de suma erronea");
		
	}

}
