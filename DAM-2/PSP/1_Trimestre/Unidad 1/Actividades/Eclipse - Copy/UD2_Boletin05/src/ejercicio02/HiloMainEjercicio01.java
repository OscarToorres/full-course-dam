package ejercicio02;

public class HiloMainEjercicio01 {
	
	public static void main(String[] args) {
				
		Thread[] hilo = new Thread[10];

		for (int i = 0; i < hilo.length; i++) {
			Factorial hilo1 = new Factorial(5 + i);
			hilo[i] = new Thread(hilo1);
			hilo[i].start();
		}
		
		System.out.println("Programa principal terminado");
		
	}
}
