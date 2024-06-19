package ejercicio02;

public class Factorial extends Thread{
	
	private int factorial = 1;
	int numero;
	
	public Factorial(int numero) {
		super();
		this.numero = numero;
	}

	public void run() {
		System.out.println("Empieza el proceso....."
				+ "Calculo del factorial de: " + numero);
		int inicial = numero;
		while(numero != 0) {
		factorial = factorial * numero;
		numero --;
		}
		System.out.println("Acabo el proceso....."
				+ "El factorial de " + inicial + " es: " + factorial);
	}
}