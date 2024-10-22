package ejercicio01;

import java.util.Random;

public class ContadorHilo extends Thread {

	private Contador contador;

	public ContadorHilo(Contador contador, String nombre) {
		super();
		this.contador = contador;
		this.setName(nombre);
	}

	public void run() {
		synchronized (contador) {
			for (int i = 0; i < 3; i++) {
				try {
					sleep((long) (Math.abs(new Random().nextInt()) % 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				contador.cuenta();
				System.out.println(getName() + ", valor del recurso compartido: " + contador.getContador());
			}
		}
		System.out.println("FIN..." + getName());
	}
}