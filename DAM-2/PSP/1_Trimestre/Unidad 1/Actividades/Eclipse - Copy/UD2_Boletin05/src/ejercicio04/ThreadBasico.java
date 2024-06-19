package ejercicio04;

import java.util.Random;

public class ThreadBasico implements Runnable {

	private String frase;
	private Random aleatorio;

	public ThreadBasico(String frase) {
		super();
		this.frase = frase;
		this.aleatorio = new Random();
	}

	@Override
	public void run() {
		long numero = (long) (Math.random()* 20 +1);
		while (numero > 0) {
			System.out.println(frase);
			numero --;
		}
	}
}