package ejercicio1;

public class Cliente extends Persona{

	private double limite_credito;
	private int cif_cliente;
	
	public Cliente(String nome, String enderezo, String localidade, int cif_cliente, double limite_credito) {
		super(nome, enderezo, localidade);
		this.limite_credito = limite_credito;
		this.cif_cliente = cif_cliente;

	}
}
