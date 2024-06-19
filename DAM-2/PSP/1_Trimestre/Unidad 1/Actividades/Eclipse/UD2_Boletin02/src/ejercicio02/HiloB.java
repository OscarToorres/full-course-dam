package ejercicio02;

public class HiloB extends Thread{

	public void run() {
		for(int i = 0; i < 30; i++) {
			System.out.print("NO");
		}
	}
}
