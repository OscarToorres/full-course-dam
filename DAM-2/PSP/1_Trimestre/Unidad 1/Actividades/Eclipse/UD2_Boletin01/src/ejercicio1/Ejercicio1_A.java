package ejercicio1;

public class Ejercicio1_A implements Runnable {

	private String nombre;
	private int tiempoAlimentacion;

	public Ejercicio1_A(String nombre, int tiempoAlimentacion) {
		super();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
	}

	public void comer() {
		try {

			System.out.printf("El ratón %s ha comenzado a alimentarse%n", nombre);
			Thread.sleep(tiempoAlimentacion * 1000);
			System.out.printf("El ratón %s ha terminado de alimentarse%n", nombre);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		this.comer();
	}

	public static void main(String[] args) {
		Ejercicio1_A fievel = new Ejercicio1_A("Fievel", 4);
		Ejercicio1_A jerry = new Ejercicio1_A("Jerry", 5);
		Ejercicio1_A pinky = new Ejercicio1_A("Pinky", 3);
		Ejercicio1_A mickey = new Ejercicio1_A("Mickey", 6);
		new Thread(fievel).start();
		new Thread(jerry).start();
		new Thread(pinky).start();
		new Thread(mickey).start();
	}
}
