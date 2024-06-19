package ejercicio06;

public class HiloMainEjercicio02{

	public static void main(String [] args) {
			
	//Instancia de Objetos
	HiloAEjercicio02 objetoA = new HiloAEjercicio02();
	HiloBEjercicio02 objetoB = new HiloBEjercicio02();
	
	//Instancia de hilos
	Thread hiloA = new Thread(objetoA);
	Thread hiloB = new Thread(objetoB);
	
	System.out.println("\n Ejecucion HiloA");
	hiloA.start();
	
	System.out.println("\n Ejecucion HiloB");
	hiloB.start();
	
	System.out.println("\n Ejecucion en main");

	
	}
}
