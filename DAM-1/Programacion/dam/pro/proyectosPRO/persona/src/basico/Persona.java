package basico;

import java.util.Date;

public class Persona {

	private String dni;
	private String nome;
	private String apelidos;
	private Date datanacimento;
	private String enderezo;
	private String cPostal;
	private String Localidade;
	private String provincia;
	private String bonificacion;

	public String getDni() {
		return dni;

	}

	public Persona(String dni, String nome, String apelidos, Date datanacimento, String enderezo, String cPostal,
			String localidade, String provincia, String string) {
		super();
		this.dni = dni;
		this.nome = nome;
		this.apelidos = apelidos;
		this.datanacimento = datanacimento;
		this.enderezo = enderezo;
		this.cPostal = cPostal;
		Localidade = localidade;
		this.provincia = provincia;
		this.bonificacion = string;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelidos() {
		return apelidos;
	}

	public void setApelidos(String apelidos) {
		this.apelidos = apelidos;
	}

	public Date getDatanacimento() {
		return datanacimento;
	}

	public void setDatanacimento(Date datanacimento) {
		this.datanacimento = datanacimento;
	}

	public String getEnderezo() {
		return enderezo;
	}

	public void setEnderezo(String enderezo) {
		this.enderezo = enderezo;
	}

	public String getcPostal() {
		return cPostal;
	}

	public void setcPostal(String cPostal) {
		this.cPostal = cPostal;
	}

	public String getLocalidade() {
		return Localidade;
	}

	public void setLocalidade(String localidade) {
		Localidade = localidade;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String toString() {
		return "persona [dni=" + dni + ", nome=" + nome + ", apelidos=" + apelidos + ", datanacimento=" + datanacimento
				+ ", enderezo=" + enderezo + ", cPostal=" + cPostal + ", Localidade=" + Localidade + ", provincia="
				+ provincia + ", bonificacion=" + bonificacion + "]";
	}

	private double calculaBonificacion() {
		double valor = 0.0;
		String cp = "15960";
		if (this.cPostal.equals("15960")) {
			valor = 100.0;
		}
		return valor;
	}

	public double getBonificacion() {
		return calculaBonificacion();
	}

}
