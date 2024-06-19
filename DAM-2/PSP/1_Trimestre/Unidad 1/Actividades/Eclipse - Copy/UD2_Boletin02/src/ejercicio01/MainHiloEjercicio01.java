package ejercicio01;

public class MainHiloEjercicio01 extends Thread {

	public static void main(String[] args) {
		
		Hilo2Ejercicio01 hilo = new Hilo2Ejercicio01();
		
		hilo.start();
		System.out.println();
		for(int i = 0; i < 30; i++) {
			System.out.print("NO");
		}

	}
}