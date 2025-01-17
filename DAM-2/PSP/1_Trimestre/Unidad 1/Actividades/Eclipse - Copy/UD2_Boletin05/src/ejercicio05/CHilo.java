package ejercicio05;

import java.util.Random;

public class CHilo implements Runnable {

	private String caracter;

	public CHilo(String caracter) {
		super();
		this.caracter = caracter;
	}

	@Override
	public void run() {
		try {
			Thread.sleep((long) (Math.abs(new Random().nextInt()) % 1000));
			System.out.println(caracter);
		} catch (InterruptedException ex) {
		}
	}

}

class LetrasHilos {
	LetrasHilos(String frase) {
		Thread[] hilo = new Thread[frase.length()];

		for (int i = 0; i < hilo.length; i++) {

			hilo[i] = new Thread(new CHilo(frase.substring(i, i + 1)));
			hilo[i].start();
		}
	}
}
