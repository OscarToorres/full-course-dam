package base;

public class Comision {

	private int[] comisiones = new int[12];
	private final int MINIMO = 50000;

	public Comision(int[] valores) {
		this.comisiones = valores;
	}

	private int sumarValores() {
		int suma = 0;
		for (int k = 0; k < this.comisiones.length; k++)
			suma += this.comisiones[k];
		return suma;
	}

	public boolean cobrarComision() {
		return (this.sumarValores() >= MINIMO) ? true : false;
	}

	public static void main(String[] args) {
		
		int[] valores = new int [] {80000, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80};
		Comision comision = new Comision(valores);
		System.out.println(comision.cobrarComision());
	}
}