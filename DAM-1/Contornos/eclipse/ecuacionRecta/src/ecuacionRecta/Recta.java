package ecuacionRecta;

import java.util.Scanner;

public class Recta {

	private Scanner scanner = new Scanner(System.in);

	public int obtencionPuntos() {
		int p1 = scanner.nextInt();
		return p1;
	}

	public int pendiente(int a1, int a2, int b1, int b2) {
		int m = (b1 - b2) / (a1 - a2);
		return m;

	}

	public int calculoOrdenda(int b2, int x0, int a2, int m) {
		int y0 = b2 + m * (x0 - a2);
		return y0;

	}

}
