package basic;

public class Ecuacion {

	private double a;
	private double b;
	private double c;

	// para generar esto se usa el el source y seleccionamos generar getterres and
	// setterers

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	// Con el Math.Sqrt () se hace la raiz cuadrada

	public double calcular() {
		return Math.sqrt(b * b - 4 * a * c);
	}

	public double x1() {
		return (-b + this.calcular()) / (2 * a);
	}
	public double x2() {
		return (-b - this.calcular()) / (2 * a);
	}

}
