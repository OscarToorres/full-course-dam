package basic;

public class EcuacionApp {

	public static void main(String[] args) {

		Ecuacion ecuacion = new Ecuacion();
		ecuacion.setA(10);
		ecuacion.setB(500);
		ecuacion.setC(11);
		double x1 = ecuacion.x1();
		double x2 = ecuacion.x2();

		System.out.println("x1= " + x1 + " x2= " + x2);

	}
}