package ejercicio1;

public class Emisor extends Persona{

private int cif_emisor;
	
	public Emisor(String nome, String enderezo, String localidade, int cif_emisor, double limite_credito) {
		super(nome, enderezo, localidade);
		this.cif_emisor = cif_emisor;

	}
}
