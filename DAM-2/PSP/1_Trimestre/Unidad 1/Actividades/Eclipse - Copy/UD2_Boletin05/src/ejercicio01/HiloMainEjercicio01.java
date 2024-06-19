package ejercicio01;

public class HiloMainEjercicio01 {
	
	public static void main(String[] args) {
		
		Factorial hilo1 = new Factorial(5);
		Fibonacci hilo2 = new Fibonacci(7);
		
		Thread hiloA = new Thread(hilo1);
		Thread hiloB = new Thread(hilo2);
		
//		hilo1.start();
//		hilo2.start();
		
		hiloA.start();
		hiloB.start();
	}
}
