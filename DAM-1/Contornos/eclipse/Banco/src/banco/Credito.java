package banco;

public class Credito extends Cuenta{
	
	private static final float XURO = 0.15F;

	public Credito(float saldo, float ingresa, float retira, float emprestimo) {
		super(saldo, ingresa, retira, emprestimo);
	}

	public float prestamo(float emprestismo) {
		super.setSaldo(super.getSaldo() + super.getEmprestimo());
		return super.getSaldo();
	}
	
	public float ingresar(float ingresa) {
		super.setSaldo(super.getSaldo() - (super.getIngresa() * Credito.XURO));
		return super.getSaldo();
	}
}
