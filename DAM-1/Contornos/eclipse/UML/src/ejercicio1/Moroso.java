package ejercicio1;

import java.util.Date;

public class Moroso extends Cliente{

	private double deuda;
	private Date data_cobro;
	
	public Moroso(String nome, String enderezo, String localidade, int cif_cliente, double limite_credito, double deuda,
			Date data_cobro) {
		super(nome, enderezo, localidade, cif_cliente, limite_credito);
		this.deuda = deuda;
		this.data_cobro = data_cobro;
	}
	

	
}