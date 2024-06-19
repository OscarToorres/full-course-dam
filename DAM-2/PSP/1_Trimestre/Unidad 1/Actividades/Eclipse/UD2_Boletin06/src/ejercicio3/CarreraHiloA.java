package ejercicio3;

public class CarreraHiloA extends Thread{
	
	private int contador;
	private String nombre;
	private boolean parar;
	
	public CarreraHiloA(int contador, String nombre) {
		super();
		this.contador = contador;
		this.nombre = nombre;
		this.parar = false;
	}
	
	public void run() {
		while(parar == false){
			contador++;
		}
		
	}
	
	public void parar() {
		parar = true;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	
	
}