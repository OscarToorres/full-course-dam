package ejercicio02;

public class MainEj2NoSincro {
	public static void main(String args[]) {
		Listado lista = new Listado();

		// Creo los objeto hilo
		Thread primero = new Ej2NoSincro(lista);
		Thread segundo = new Ej2NoSincro(lista);

		// Los lanzo
		primero.start();
		segundo.start();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException ex) {
			System.out.printf("Interrupcion");
		}
		System.out.println("\nYa termine.");
	}
}