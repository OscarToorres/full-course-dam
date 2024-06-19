package base;

public class Superficie {

	private double base = 0;
	private double altura = 0;

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		if (base > 0)
			this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		if (altura > 0)
			this.altura = altura;
	}

	public double area() {
		return base * altura;
	}

	public static void main(String[] args) {

		Superficie rectangulo = new Superficie();

		rectangulo.setBase(2);
		rectangulo.setAltura(5);
		System.out.println(rectangulo.area());

	}
}