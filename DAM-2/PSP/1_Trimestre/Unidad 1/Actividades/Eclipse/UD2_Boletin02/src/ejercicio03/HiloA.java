package ejercicio03;

public class HiloA extends Thread {
	
	static Integer contador = 0;
	private String cadena;
	
	public HiloA(String cadena) {
		super();
		this.cadena = cadena;
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.print(++contador + ":" + this.cadena + " ");
		}
	}
}