package ejercicio03;

public class ContarThread extends Thread{

	private int maxContar;

	public ContarThread(int maxContar) {
		super();
		this.maxContar = maxContar;
	}
	
	public void run() {
		for (int i = 0; i < maxContar; i++) {
		System.out.println("Repeticion " + (i+1));
		System.out.println("Nombre del hilo: " + getName());
		
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
}
