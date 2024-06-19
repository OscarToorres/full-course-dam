package ejercicio06;

public class HiloMainEjercicio01 {

	public static void main(String[] args) {
		//Crear el objeto
		Hilo2Ejercicio01 objeto1 = new Hilo2Ejercicio01();
		
		//Crear el hilo
		Thread hilo = new Thread(objeto1);
		
		//Se inician los procesos
		hilo.start();
		System.out.println();
		for(int i = 0; i < 30; i++) {
			System.out.print("NO");
		}
	}
}