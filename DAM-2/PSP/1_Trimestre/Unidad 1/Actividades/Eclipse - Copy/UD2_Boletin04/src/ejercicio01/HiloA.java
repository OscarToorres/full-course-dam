package ejercicio01;

public class HiloA extends Thread {
	
	String nombre;
	int tiempoEspera;
		
	public HiloA(String nombre, int tiempoEspera) {
		super();
		this.nombre = nombre;
		this.tiempoEspera = tiempoEspera;
	}

	public void run() {
		try {
			Thread.sleep(tiempoEspera);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
