package clientebanco;

public class ClienteApp {

	public static void main(String[] args) {

		boolean tarjetaCredito = true;
		Cliente cliente = new Cliente("Maria", 500, tarjetaCredito);
		System.out.println(cliente.toString());
	}
}