package ejercicio04;

public class HiloMainEjercicio04 extends Thread{

	public static void main(String [] args) {
		
		HiloEjercio04 hilo1 = new HiloEjercio04(10, 20, "ThreadA");
		HiloEjercio04 hilo2 = new HiloEjercio04(29, 34, "ThreadB");
	
		System.out.println("Vamos a iniciar los dos Threads");
		System.out.println("Hilos iniciados");
		hilo1.start();
		hilo2.start();
		System.out.println("Programa principal terminado");
	}
}