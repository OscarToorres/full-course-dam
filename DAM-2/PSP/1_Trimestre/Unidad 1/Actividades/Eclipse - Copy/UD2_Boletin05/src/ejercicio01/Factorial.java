package ejercicio01;

public class Factorial implements Runnable{
	
	private int factorial = 1;
	int numero;
	
	public Factorial(int numero) {
		super();
		this.numero = numero;
	}

	public void run() {
		int inicial = numero;
		while(numero != 0) {
		factorial = factorial * numero;
		numero --;
		}
		System.out.println("El factorial de " + inicial +
				" es: " + factorial);
	}

}
