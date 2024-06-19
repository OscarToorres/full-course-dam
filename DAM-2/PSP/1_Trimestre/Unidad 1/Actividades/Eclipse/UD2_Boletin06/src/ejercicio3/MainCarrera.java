package ejercicio3;

public class MainCarrera {

	public static void main(String[] args) {

		CarreraHiloA h1 = new CarreraHiloA(0, "Hilo 1");
		CarreraHiloA h2 = new CarreraHiloA(10, "Hilo 2");
		
//		h1.setPriority(Thread.MIN_PRIORITY);
//		h2.setPriority(Thread.MAX_PRIORITY);
		
		h1.start();
		h2.start();
		
		while (h1.getContador() != h2.getContador()) {
			System.out.println("Ta contando");
		}
		
		h1.parar();
		h2.parar();
		
		System.out.println("Contador en h1 -> " + h1.getContador() );
		System.out.println("Contador en h2 -> " + h2.getContador());
		System.out.println("FIN");
		
	}
}