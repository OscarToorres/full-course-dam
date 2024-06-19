package base;

public class Ive {
	
	//TAREFAS
	//1. Verifica o funcionamento desta clase mediante o método main()
	//2. Refactoriza o método que se indica
	//3. Deseña e executa as probas unitarias con JUnit

	private double[] ingresos = new double[12];
	private static final double COTA_IVE = 0.21;

	public Ive(double[] ingresos) {
		super();
		this.ingresos = ingresos;
	}

	private boolean valoresPositivos() {
		for (int k = 0; k < this.ingresos.length; k++) {
			if (this.ingresos[k] < 0.0)
				return false;
		}
		return true;
	}

	//refactoriza este método
	public double calcularIve() {
		boolean todosPositivos = true;
		for (int k = 0; k < this.ingresos.length; k++) {
			if (this.ingresos[k] < 0.0) {
				todosPositivos = false;
				break;
			}
		}
		double suma = 0.0;
		if (todosPositivos) {
			for (int k = 0; k < this.ingresos.length; k++) {
				suma = suma + this.ingresos[k];
			}
		}
		return suma * COTA_IVE;
	}

	public static void main(String[] args) {
		//valores de proba
		double[] ingresos = { 1000.0, -1000.0, 1000.0, 1000.0, 1000.0, 
							1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 
							1000.0,	1000.0 };
		
		Ive resultado = new Ive(ingresos);
		//visualización do resultado
		System.out.println(resultado.calcularIve());
	}

}