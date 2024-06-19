package ejercicio01;

public class Sincronizada extends Thread {
	private ObjetoComun comparti;
	private String nom;

	// Constructores
	public Sincronizada() {
	}

	public Sincronizada(String nombre, ObjetoComun compartido) {
		comparti = compartido;
		nom = nombre;
	}

	//La primera forma es añadir el syncriniced y meter la accion que se
	//quiera sincronizar dentro
	public void run() {
		synchronized (comparti) {
			comparti.Mostrar(nom);

		}
	}
}