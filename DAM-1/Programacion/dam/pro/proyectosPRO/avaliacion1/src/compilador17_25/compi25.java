package compilador17_25;

public class compi25 {

	public static void main(String[] args) {
		int i = 8;
		int j = 1;

		System.out.println("Resultado:");
		System.out.println("");

		while (i <= 144) {
			System.out.println("" + i);
			i = 8 * (j + 1);
			j++;
		}
	}

}
