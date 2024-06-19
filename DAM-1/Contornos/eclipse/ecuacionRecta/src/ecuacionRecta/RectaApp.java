package ecuacionRecta;

public class RectaApp {

	private static final String A = "Punto A";
	private static final String B = "Punto B";
	private static final String X0 = "abscisa x0 = ";
	private static final String Y0 = "ordenada y0 = ";
	private static final String PENDIENTE = "Valor pendente da recta m = ";
	private static final String ABSCISA = "Valor abscisa x = ";

	public static void main(String[] args) {

		Recta recta = new Recta();

		System.out.print(A + X0);
		int a1 = recta.obtencionPuntos();
		System.out.print(A + Y0);
		int b1 = recta.obtencionPuntos();
		Punto A = new Punto(a1, b1);
		System.out.print(B + X0);
		int a2 = recta.obtencionPuntos();

		System.out.print(B + Y0);
		int b2 = recta.obtencionPuntos();

		Punto B = new Punto(a2, b2);

		System.out.println(A.toString());
		System.out.println(B.toString());

		System.out.print(PENDIENTE);

		int m = recta.pendiente(a1, a2, b1, b2);
		System.out.println(m);

		System.out.print(ABSCISA);

		int x0 = recta.obtencionPuntos();

		int y0 = recta.calculoOrdenda(b2, x0, a2, m);
		Punto P = new Punto(x0, y0);
		System.out.println(P.toString());
	}
}
