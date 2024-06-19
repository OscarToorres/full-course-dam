package ejercicio02;

public class MainCajero {

	public static void main(String[] args) {
		Cajero cajero = new Cajero("Santander");
		
		Terminal terminal1 = new Terminal(cajero, "Terminal 1");
		Terminal terminal2 = new Terminal(cajero, "Terminal 2");
		Terminal terminal3 = new Terminal(cajero, "Terminal 3");
					
		System.out.println("Nombre del cajero: " + cajero.getNombre());

		terminal1.start();
		terminal2.start();
		terminal3.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Total de localidades vendidas " + cajero.getLocalidades());
		System.out.println("Fin del programa");
		
	}
}
