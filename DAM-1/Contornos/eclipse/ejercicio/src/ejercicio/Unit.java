package ejercicio;

public class Unit {

	// valor dun rublo en euros, por exemplo, 0.0095
	private double rublo;

	// valor dun euro en rublos, por exemplo, 113.9670
	private double euro;

	private double cantidade;

	public Unit(double rublo, double euro, double cantidade) {
		super();
		this.rublo = rublo;
		this.euro = euro;
		this.cantidade = cantidade;
	}

	public double getRublo() {
		return rublo;
	}

	public double getEuro() {
		return euro;
	}

	public double getCantidade() {
		return cantidade;
	}

}