package ejercicio02;

public class Hilo1 extends Thread{
	
	int tiempoDormido;
	String nombre;
	
	public Hilo1(String nombre) {
		super();
		this.nombre = nombre;
	}

	public void run() {
		tiempoDormido = (int) (Math.random() * (10*1000) + 1);
		try {
			System.out.println(nombre + " va a estar dormido durante " + tiempoDormido + " milisegundos");
			Thread.sleep(tiempoDormido);
			System.out.println(nombre + " ha derpertado");
			
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
