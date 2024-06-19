package clientes;

public class Cliente {

	private String nif;
	private String nome;
	private String email;
	private String pwd;

	public Cliente(String nif, String nome, String email) {

		super();
		this.nif = nif;
		this.nome = nome;
		this.email = email;
		Password password = new Password();
		this.pwd = password.getPassword();

	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String toString() {
		return "Cliente [nif=" + nif + ", nome=" + nome + ", email=" + email + ", pwd=" + pwd + "]";
	}

}
