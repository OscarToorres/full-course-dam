package ejercicio01;

public class MainSincronizada {
	
	public static void main(String args[]) {
		ObjetoComun compartido = new ObjetoComun();

		//Creo los 4 hilos que usarán el objeto compartido anterior
		Sincronizada dibujo1 = new Sincronizada("Caperucita", compartido);
		Sincronizada dibujo2 = new Sincronizada("Blancanieves", compartido);
		Sincronizada dibujo3 = new Sincronizada("Pinocho", compartido);
		Sincronizada dibujo4 = new Sincronizada("Pulgarcito", compartido);

		//Lanzo los hilos 
		dibujo1.start();
		dibujo2.start();
		dibujo3.start();
		dibujo4.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException ex) {
			System.out.printf("Interrupcion");
		}

		System.out.println("Hemos terminado amiguitos");
	}
}