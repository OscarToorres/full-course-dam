package teoria.capitulo04;

import misClases.teoria.CCuenta;

public class CAPCuenta {

	public static void main(String[] args) {
		CCuenta cuenta = new CCuenta();
		
		cuenta.IngresarDinero(1000000);
		cuenta.EstablecerTipoDeInteres(5);
		
		System.out.println(cuenta.SaldoActual());
		cuenta.IngresarDinero(500000);
		cuenta.RetirarDinero(200000);
		System.out.println(cuenta.SaldoActual());
		cuenta.AbonarInteres();
		System.out.println(cuenta.SaldoActual());
	}
}