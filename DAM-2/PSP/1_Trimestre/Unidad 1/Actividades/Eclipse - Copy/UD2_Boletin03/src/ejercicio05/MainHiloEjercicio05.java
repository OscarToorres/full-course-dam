package ejercicio05;

public class MainHiloEjercicio05 {

	public static void main(String[] args) {
		
		HiloA hilo1 = new HiloA();
		HiloB hilo2 = new HiloB();
		
		hilo1.start();
		hilo2.start();		
	}
}