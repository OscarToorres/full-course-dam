package ejercicio05;

public class HiloB extends Thread{
	
	public void run() {
		for (int i = 0; i <=5; i++) {
			System.out.println(i);
		}
	}
}