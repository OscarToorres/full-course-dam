package cualificar;

public class Cualificar {

	private String nome;
	private int cualificacion;
	private int modulo;
	private String dni;
	
	public Cualificar(String nome, int cualificacion, int modulo, String dni) {
		this.cualificacion= cualificacion;
		this.dni = dni;
		this.modulo = modulo;
		this.nome = nome;
	
	}
	
	public boolean aprobado() {
		boolean aprobado = false;
		if (this.cualificacion >= 5)
			aprobado = true;
		return aprobado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCualificacion() {
		return cualificacion;
	}

	public void setCualificacion(int cualificacion) {
		if (cualificacion <= 10 && cualificacion >= 1) 
			this.cualificacion = cualificacion;
		else
			this.cualificacion = -1;
	}

	public int getModulo() {
		return modulo;
	}

	public void setModulo(int modulo) {
		this.modulo = modulo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
	
	
	
	
}
