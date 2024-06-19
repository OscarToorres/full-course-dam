package ejercicio01;

public class Hilo2Ejercicio01 extends Thread {
	
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.print("YES");
		}
	}

}
