package compilador17_25;

public class compi20 {
	public static void main(String[] ar) {
		int a = 1, b = 1, c;

		System.out.println("Resultado:");
		System.out.println();

		while (a <= 1000) {
			System.out.println(a);
			c = a + b;
			a = b;
			b = c;

		}
	}
}
