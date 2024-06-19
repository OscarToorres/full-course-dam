package ejercicio2;

import java.util.Date;

public class Empregado extends Persona {

	private double salario;
	private String departamento;
	private Date data_contrato;
	
	public Empregado(String nome, String dni, String localidade, int tlf, double salario, String departamento,
			Date data_contrato) {
		super(nome, dni, localidade, tlf);
		this.salario = salario;
		this.departamento = departamento;
		this.data_contrato = data_contrato;
	}
	
	
}
