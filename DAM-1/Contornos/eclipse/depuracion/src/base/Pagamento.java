package base;

//import java.util.Scanner;

public class Pagamento {

	private double [] ingresos = new double[12];
	private static final double COTA_IVE = 0.21;
	
	
	
	public Pagamento(double[] ingresos) {
		super();
		this.ingresos = ingresos;
	}

	private boolean valoresPositivos() {
		
		for(int k = 0; k < this.ingresos.length; k++) {
			if (this.ingresos[k] < 0.0)
				return false;
		}
		return true;
	}

	public double calcularIve () {
		boolean ok = this.valoresPositivos();
		double suma = 0.0;
		if (ok) {
			for (int k = 0; k < this.ingresos.length; k++) {
				suma = suma + this.ingresos[k];
			}
		}
		return suma * COTA_IVE;
	}

	/*
	private double mes[] = new double[12];
	private double total;
	Scanner teclado = new java.util.Scanner(System.in);

	public double calculoTrimestral() {
		int i = 0;

		while (i < 12) {
			System.out.print("Mes " + (i + 1) + ": ");
			mes[i] = teclado.nextFloat();
			if (mes[i] < 0) {
				while (mes[i] < 0) {
					System.out.print("Mes " + (i + 1) + ": ");
					mes[i] = teclado.nextFloat();
				}
			}
			total = mes[i] + total;
			i++;
		}
		return total;
	}

	public double resultado() {
		total = total * 0.21;
		return total;
	}
	 */
	
	
	public static void main(String[] args) {
		double [] ingresos = {12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};
		Pagamento ive = new Pagamento(ingresos);
		double resultado = ive.calcularIve();
		System.out.println(resultado);
		
		
		/*
		Pagamento mostrar = new Pagamento();

		mostrar.calculoTrimestral();
		System.out.println(mostrar.resultado());
		*/
	}

}
