package listas;

import java.util.Date;

public class Empregado {
	
	String nome;
	String dni;
	Date fecha;
	
	public Empregado(String nome, String dni, Date date) {
		super();
		this.nome = nome;
		this.dni = dni;
		this.fecha = date;
	}

	@Override
	public String toString() {
		return "Empregado [nome=" + nome + ", dni=" + dni + ", fecha=" + fecha + "]";
	}
	
	
}