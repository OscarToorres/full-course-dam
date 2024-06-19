package ejercicio04;

public class HiloEjercio04 extends Thread{
	
	private Integer principio, fin;
	private String nombre;
	
	public HiloEjercio04(Integer principio, Integer fin, String nombre) {
		super();
		this.principio = principio;
		this.fin = fin;
		this.nombre = nombre;
	}
	
	public void run() {
		System.out.println(nombre + " empieza...");
		while (principio < fin) {
			System.out.println(nombre + " dice: " + principio + ".");
			principio++;
		}
		System.out.println(nombre + " acaba.");
	}
}