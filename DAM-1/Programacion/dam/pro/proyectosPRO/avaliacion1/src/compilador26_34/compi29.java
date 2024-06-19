package compilador26_34;

public class compi29 {

	public static void main(String[] args) {

		System.out.println("Resultado: ");
		System.out.println();
		
		for (int a = 1, b = 1, c = 0; a <= 1000; c = a + b) {
			System.out.println(a);
			a = b;
			b = c;	
		}
	}

}
