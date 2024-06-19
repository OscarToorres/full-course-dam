package misClases.teoria;

public class CCuenta {

	private double tipoDeInteres;
	private double saldo;

	public void EstablecerTipoDeInteres(double ti) {
		tipoDeInteres = ti;

		if (ti < 0) {
			System.out.println("El tipo de interes no puede ser negativo");
			return;
		}
	}

	public void IngresarDinero(double ingreso) {
		saldo += ingreso;
	}

	public void RetirarDinero(double cantidad) {
		
		if (saldo - cantidad < 0) {
			System.out.println("No tienes saldo suficiente");
			return;
		}
		saldo -= cantidad;
	}

	public double SaldoActual() {
		return saldo;
	}

	public void AbonarInteres() {
		saldo += saldo * tipoDeInteres / 100;
	}
}