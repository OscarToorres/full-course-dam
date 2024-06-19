package ejercicio04;

public class ThreadBasicoMain {

	public static void main(String[] args) {
		String frase = "Buenos dias";
		String frase2 = "Hasta luego, buenas noches";
		
		ThreadBasico hilo = new ThreadBasico(frase);
		ThreadBasico hilo2 = new ThreadBasico(frase2);
		
		Thread hiloA = new Thread(hilo);
		Thread hiloB = new Thread(hilo2);
		
		hiloA.start();
		hiloB.start();

	}

}
