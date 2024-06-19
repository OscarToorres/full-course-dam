package ejercicio02;

public class HiloA extends Thread {

	public void run() {
		for(int i = 0; i < 30; i++) {
			System.out.print("YES");
		}
	}
}