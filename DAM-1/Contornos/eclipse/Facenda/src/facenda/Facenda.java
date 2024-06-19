package facenda;

public class Facenda {

	private static final float IRPF = 0.15F;
	private float salario;
	private String DNI;
	private String CIF;

	public Facenda(float salario, String dNI, String cIF) {
		super();
		this.salario = salario;
		DNI = dNI;
		CIF = cIF;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

}
