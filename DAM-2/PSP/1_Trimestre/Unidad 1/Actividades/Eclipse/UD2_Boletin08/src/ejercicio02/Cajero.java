package ejercicio02;

public class Cajero {

	private int localidades;
	private String nombre;	
	
	public Cajero(String nombre) {
		super();
		this.nombre = nombre;
	}

	public void sumarLocalidades() {
		localidades++;
	}

	public int getLocalidades() {
		return localidades;
	}

	public String getNombre() {
		return nombre;
	}	
}