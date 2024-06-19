package ejercicio01;

public class ObjetoComun {
	
	//La segunda forma se le añade la palabra synchronized al metodo
	public synchronized void Mostrar(String mensaje) {
		System.out.println("¡En marcha...! " + mensaje);

		try {
			Thread.sleep(2000);
			System.out.println("!He llegado¡ " + mensaje);

		} catch (InterruptedException ex) {
			System.out.printf("Interrupcion");
		}
	}
}
