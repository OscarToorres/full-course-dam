package basico;

import java.util.Date;

public class Empregada {
	private int id;
	private String dni;
	private String nome;
	private Date dataNacimiento;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(int i) {
		this.dni = i;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNacimiento() {
		return dataNacimiento;
	}
	public void setDataNacimiento(Date dataNacimiento) {
		this.dataNacimiento = dataNacimiento;
	}
	@Override
	public String toString() {
		return "Empregada [id=" + id + ", dni=" + dni + ", nome=" + nome + ", dataNacimiento=" + dataNacimiento + "]";
	}
	
	
	
}
	
	