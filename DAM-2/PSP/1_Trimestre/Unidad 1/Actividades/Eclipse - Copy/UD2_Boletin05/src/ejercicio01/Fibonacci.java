package ejercicio01;

public class Fibonacci implements Runnable{

	int numero, num1 = 0, num2 = 1, suma = 1;
	
	public Fibonacci(int numero) {
		super();
		this.numero = numero;
	}

	public void run() {
		for (int i = 1; i < numero; i++) {

			suma = num1 + num2;
			num1 = num2;
			num2 = suma;
		}
		System.out.println("El resultado de Fibonacci del numero:"
				+ " " + numero + " es: " + suma);
	}

}
