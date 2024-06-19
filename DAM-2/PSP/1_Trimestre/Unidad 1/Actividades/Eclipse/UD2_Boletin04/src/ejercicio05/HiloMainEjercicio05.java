package ejercicio05;

public class HiloMainEjercicio05 {

	public static void main(String[] args) throws InterruptedException {

		Hilo hilo1  = new Hilo("Josefina");
		Hilo hilo2 = new Hilo("Manolo");
		
		System.out.println("Aun no se han iniciado los hilos");
		
		hilo1.start();
		hilo1.join();
		System.out.println(hilo1.getName() + " ha terminado");
		
		hilo2.start();
		hilo2.join();
		System.out.println(hilo2.getName() + " ha terminado");

		System.out.println("Fin del programa");
	}

}
