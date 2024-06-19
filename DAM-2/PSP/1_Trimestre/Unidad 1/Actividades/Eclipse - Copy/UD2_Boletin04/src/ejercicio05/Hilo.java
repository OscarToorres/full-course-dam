package ejercicio05;

public class Hilo extends Thread{
	
	Hilo (String nombre){
		super (nombre);
	}
	
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.print(i + " ");
		}
	}

}
