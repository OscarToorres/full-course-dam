package clientebanco;

public class Cliente {

	private String nombre;
	private int saldoCuenta;
	private boolean tarjetaCredito;

	public Cliente(String nombre, int saldoCuenta, boolean tarjetaCredito) {
		super();
		this.nombre = nombre;
		this.saldoCuenta = saldoCuenta;
		this.tarjetaCredito = tarjetaCredito;
		this.saldoCuenta = calcularGastos();
	}

	private int gastoCuenta() {
		if (this.saldoCuenta < 40000) {
			this.saldoCuenta = this.saldoCuenta - 40;
		}
		return this.saldoCuenta;
	}

	private int gastoVisa() {
		if ((this.saldoCuenta < 20000) && (this.tarjetaCredito)) {
			this.saldoCuenta = this.saldoCuenta - 20;
		}
		return this.saldoCuenta;
	}

	private int calcularGastos() {
		this.saldoCuenta = this.gastoCuenta();
		this.saldoCuenta = this.gastoVisa();
		return this.saldoCuenta;
	}

	public String toString() {
		return "Cliente [nombre=" + nombre + ", saldoCuenta=" + saldoCuenta + ", tarjetaCredito=" + tarjetaCredito
				+ "]";
	}
}