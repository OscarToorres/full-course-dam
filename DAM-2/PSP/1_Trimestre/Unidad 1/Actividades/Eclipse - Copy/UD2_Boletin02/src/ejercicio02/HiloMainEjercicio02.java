package ejercicio02;

public class HiloMainEjercicio02 extends Thread{

	public static void main(String [] args) {
		
	
	//Instancia de hilos
	HiloA hiloA = new HiloA();
	HiloB hiloB = new HiloB();
	
	System.out.println("\n Ejecucion HiloA");
	hiloA.start();
	
	System.out.println("\n Ejecucion HiloB");
	hiloB.start();
	
	System.out.println("\n Ejecucion en main");

	
	}
}
