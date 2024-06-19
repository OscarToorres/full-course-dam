package ejercicio06;

public class HiloAEjercicio03 implements Runnable{
	
	static Integer contador = 0;
	private String cadena;
	
	public HiloAEjercicio03(String cadena) {
		super();
		this.cadena = cadena;
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.print(++contador + ":" + this.cadena + " ");
		}
	}
}