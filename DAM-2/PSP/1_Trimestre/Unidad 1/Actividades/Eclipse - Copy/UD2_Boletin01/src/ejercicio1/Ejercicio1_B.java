package ejercicio1;

public class Ejercicio1_B implements Runnable {

	private String nombre;
	private int tiempoAlimentacion;

	public Ejercicio1_B(String nombre, int tiempoAlimentacion) {
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
		Ejercicio1_B fievel = new Ejercicio1_B("Fievel", 4);
		Ejercicio1_B jerry = new Ejercicio1_B("Jerry", 5);
		Ejercicio1_B pinky = new Ejercicio1_B("Pinky", 3);
		Ejercicio1_B mickey = new Ejercicio1_B("Mickey", 6);
		new Thread(fievel).run();
		new Thread(jerry).run();
		new Thread(pinky).run();
		new Thread(mickey).run();
	}
}