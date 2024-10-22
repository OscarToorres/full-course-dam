package ejercicio02;

public class Terminal extends Thread {

	private Cajero cajero;
	private String nombre;
	private int localidad;

	public Terminal(Cajero cajero, String nombre) {
		super();
		this.cajero = cajero;
		this.nombre = nombre;
	}

	public void run() {
		synchronized (cajero) {
			for (int i = 0; i < 20000; i++) {
				cajero.sumarLocalidades();// suma en el total
				localidad++;
			}
			System.out.println(nombre + " vendio " + localidad);
		}
	}

}
