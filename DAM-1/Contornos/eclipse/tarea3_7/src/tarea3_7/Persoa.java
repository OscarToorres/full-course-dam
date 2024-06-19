package tarea3_7;

public class Persoa {
	
	private String apelido1;
	private String apelido2;
	private String nome;
	private String dni;
	private double estatura;
	private double peso;
	
	public Persoa(String apelido1, String apelido2, String nome, String dni, double estatura) {
		super();
		this.apelido1 = apelido1;
		this.apelido2 = apelido2;
		this.nome = nome;
		this.dni = dni;
		this.estatura = estatura;
		
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getDni() {
		return dni;
	}

	public double getEstatura() {
		return estatura;
	}
	
	public String getApelidosNome() {
		return apelido2.concat(" ").concat(apelido1).concat(", ").concat(nome);
	}

	@Override
	public String toString() {
		return "Persoa [dni=" + dni + ", estatura=" + estatura + ", peso=" + peso + ", getApelidosNome()="
				+ getApelidosNome() + "]";
	}
	
	

}