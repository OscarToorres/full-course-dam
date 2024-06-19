package heranza;

public class App {

	public static void main(String[]args) {
		
		Forma forma = new Forma(30,40);
		
		String res = forma.toString();
		System.out.println(res);
		
		System.out.println("Rectangulo");
		Rectangulo rectangulo = new Rectangulo(200,500);
		System.out.println(rectangulo.calcularPerimetro());
		System.out.println(rectangulo.calcularSuperficie());
		
		System.out.println("Triangulo Rectangulo");
		TrianguloRectangulo triangulo = new TrianguloRectangulo(4, 2);
		System.out.println(triangulo.calcularPerimetro());
		System.out.println(triangulo.calcularSuperficie());
		
	}
}
