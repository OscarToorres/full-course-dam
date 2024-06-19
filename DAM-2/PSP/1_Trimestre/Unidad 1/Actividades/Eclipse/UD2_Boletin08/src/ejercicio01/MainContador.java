package ejercicio01;

public class MainContador {

	public static void main(String[] args) {

		Contador cuenta = new Contador();
		
		ContadorHilo hilo1 = new ContadorHilo(cuenta, "Hilo1");
		ContadorHilo hilo2 = new ContadorHilo(cuenta, "Hilo2");
		ContadorHilo hilo3 = new ContadorHilo(cuenta, "Hilo3");
		ContadorHilo hilo4 = new ContadorHilo(cuenta, "Hilo4");
					
		hilo2.start();
		hilo4.start();
		hilo1.start();
		hilo3.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Fin del Main");
	}
}