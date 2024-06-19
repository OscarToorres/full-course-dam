package ejercicio04;

public class HiloMainEjercicio04 {

	public static void main(String[] args) {

		HiloA hilo = new HiloA();
		
//		System.out.println("Aun no se ha iniciado el hilo");
//		hilo.start();
//		System.out.println(hilo.getName() + " ha terminado");
//		System.out.println("Fin del programa");	
		
		System.out.println("Aun no se ha iniciado el hilo");
		
		try {
			hilo.start();
			hilo.join();
			System.out.println(hilo.getName() + " ha terminado");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fin del programa");
		
	}

	

}
