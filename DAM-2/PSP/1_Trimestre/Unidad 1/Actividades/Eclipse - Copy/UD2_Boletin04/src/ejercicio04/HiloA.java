package ejercicio04;

public class HiloA extends Thread{
	
	public void run() {
		for(int i = 0; i <= 10; i++) {
			System.out.print(i + " ");
		}
	}

}
