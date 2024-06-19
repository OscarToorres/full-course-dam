package ejercicio01;

public class Ejer1Prioridad implements Runnable {
	
	private int contador = 0;
	
	public void run() {
		for (int i = 0; i < 100000000; i++) {
			contador++;
		}
		System.out.println(Thread.currentThread().getName() + 
				"Prioridad: " + Thread.currentThread().getPriority()
				+ ". Fin de la ejecucion");
	}
}