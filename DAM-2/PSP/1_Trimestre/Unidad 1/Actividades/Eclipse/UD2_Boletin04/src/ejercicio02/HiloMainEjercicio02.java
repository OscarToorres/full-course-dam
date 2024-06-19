package ejercicio02;

public class HiloMainEjercicio02 {

	public static void main(String[] args) {
		
		Hilo1 hiloA = new Hilo1("Manolo");
		Hilo1 hiloB = new Hilo1("Juan");
		Hilo1 hiloC = new Hilo1("Alberto");
		
		System.out.println("Iniciando subprocesos");
		hiloA.start();
		hiloB.start();
		hiloC.start();
		System.out.println("Subprocesos terminados, termina el main");
	}

}
