package tarea3_6;

public class Clienta {
	
	private String dni;
	private double saldo;

	public Clienta(String dni, double saldo) {
		this.dni = dni;
		this.saldo = saldo;
	}

	public String getDni() {
		return dni;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Clienta{" + "dni='" + dni + '\'' + ", saldo= " + saldo + '}';
	}
}
