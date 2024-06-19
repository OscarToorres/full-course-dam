package ejercicio03;

public class ContarApp {

	public static void main(String[] args) {

		ContarThread hilo = new ContarThread(5);
		ContarThread hilo1 = new ContarThread(4);

		hilo.start();
		try {
			hilo.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hilo1.start();

		try {
			while (hilo.isAlive() || hilo1.isAlive()) {
				System.out.println("Sigo Contando....");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}