package ejercicio1;

import java.util.Date;

public class Factura {

	private double importe;
	private Date data_emisor;
	private Date data_pagamento;
	private Emisor cif_emisor;
	private Cliente cid_cliente;
	
	public Factura(double importe, Date data_emisor, Date data_pagamento, Emisor cif_emisor, Cliente cid_cliente) {
		super();
		this.importe = importe;
		this.data_emisor = data_emisor;
		this.data_pagamento = data_pagamento;
		this.cif_emisor = cif_emisor;
		this.cid_cliente = cid_cliente;
	}
}
