package ejercicio02;

public class Listado {
	public synchronized void Mostrar() {
		System.out.println("\nEsta es mi salida ");
		for (int i = 0; i < 8; i++) {
			System.out.print(i + " ");
		}
	}
}