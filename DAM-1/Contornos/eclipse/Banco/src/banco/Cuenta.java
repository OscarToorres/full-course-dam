package banco;

public class Cuenta {
	
	private float saldo;
	private float ingresa;
	private float retira;
	private float emprestimo;
	private static final float XURO = 0.15F;
	
	public Cuenta(float saldo, float ingresa, float retira, float emprestimo) {
		super();
		this.saldo = saldo;
		this.ingresa = ingresa;
		this.retira = retira;
		this.emprestimo = emprestimo;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public float getIngresa() {
		return ingresa;
	}

	public void setIngresa(float ingresa) {
		this.ingresa = ingresa;
	}

	public float getRetira() {
		return retira;
	}

	public void setRetira(float retira) {
		this.retira = retira;
	}

	public float getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(float emprestimo) {
		this.emprestimo = emprestimo;
	}
	
	
	
}