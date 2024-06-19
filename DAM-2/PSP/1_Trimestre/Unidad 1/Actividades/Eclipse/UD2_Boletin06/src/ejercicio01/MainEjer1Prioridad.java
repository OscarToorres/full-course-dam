package ejercicio01;

public class MainEjer1Prioridad {

	public static void main(String[] args) {
		Ejer1Prioridad p = new Ejer1Prioridad();
		
		Thread hilo2 = new Thread(p);
		
		hilo2.setPriority(Thread.MAX_PRIORITY);
		System.out.println("Comenzando " + hilo2.getName() + "...");
		hilo2.start();
		
		Thread hilo3 = new Thread(p);
		hilo3.setPriority(Thread.NORM_PRIORITY + 1);
		System.out.println("Comenzando " + hilo3.getName() + "...");
		hilo3.start();
		
		System.out.println("Ejecutandose " + Thread.activeCount() + " hilos");
		
		try {
			hilo2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			hilo3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
