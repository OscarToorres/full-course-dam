package ejercicio03;

public class HiloMainEjercico03 {
	
	public static void main(String [] args) {
		
		HiloA hilo1 = new HiloA("YES");
		HiloA hilo2 = new HiloA("NO");
		
		System.out.println("Comienzo de la ejecucion concurrente:");
		hilo1.start();
		hilo2.start();		
	}
}