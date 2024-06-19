package ejercicio06;

public class HiloMainEjercicio04 {

	public static void main(String [] args) {
		
		//Creacion de objetos
		HiloEjercio04 objeto1 = new HiloEjercio04(10, 20, "ThreadA");
		HiloEjercio04 objeto2 = new HiloEjercio04(29, 34, "ThreadB");
	
		//Creacion de hilos
		Thread hilo1 = new Thread(objeto1);
		Thread hilo2 = new Thread(objeto2);
		
		System.out.println("Vamos a iniciar los dos Threads");
		System.out.println("Hilos iniciados");
		hilo1.start();
		hilo2.start();
		System.out.println("Programa principal terminado");
	}
}