package ejercicio06;

public class HiloMainEjercico03 {
	
	public static void main(String [] args) {
		
		//Creacion de objetos
		HiloAEjercicio03 objeto1= new HiloAEjercicio03("YES");
		HiloAEjercicio03 objeto2= new HiloAEjercicio03("NO");
		
		//Instanciar hilos
		Thread hilo1 = new Thread(objeto1);
		Thread hilo2 = new Thread(objeto2);
		
		System.out.println("Comienzo de la ejecucion concurrente:");
		hilo1.start();
		hilo2.start();		
	}
}