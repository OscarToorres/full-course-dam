package ejercicio2;

public class Cliente extends Persona{

	private double pago;
	private double credito;
	private String empresa;
	
	public Cliente(String nome, String dni, String localidade, int tlf, double pago, double credito, String empresa) {
		super(nome, dni, localidade, tlf);
		this.pago = pago;
		this.credito = credito;
		this.empresa = empresa;
	}
}
