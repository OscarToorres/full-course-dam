package ejercicio03;

public class HiloMainEjercicio03 implements Runnable{

	public void run() {
		System.out.println("El hilo se esta ejecutando");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		HiloMainEjercicio03 hilo1 = new HiloMainEjercicio03();
		Thread hilo = new Thread(hilo1);
		
		hilo.setName("Manolo");
		
		try {
			System.out.println("Ejecutando proceso principal");
			hilo.start();
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Termino: " + hilo.getName());
		System.out.println("Prioridad: " + hilo.getPriority());
	}
}
