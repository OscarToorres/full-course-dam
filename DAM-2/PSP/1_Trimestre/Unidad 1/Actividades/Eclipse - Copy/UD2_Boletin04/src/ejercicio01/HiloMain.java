package ejercicio01;

public class HiloMain {

	public static void main(String[] args) {
		
		HiloA hiloA = new HiloA("Manolo", 2000);  
		Thread hilo1 = new Thread(hiloA);

		try {
			System.out.println("\nEstado antes de ejecutarse: " + hilo1.isAlive());
			hilo1.start();
			System.out.println("Estado en ejecucion: " + hilo1.isAlive());
			hilo1.join();
		}catch(Exception ex){
			
		}
		
		System.out.println("Estado despues de ejecutarse: " + hilo1.isAlive());	
	}
}