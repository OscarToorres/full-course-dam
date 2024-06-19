package clientes;

public class ClienteApp {

	public static void main(String[] args) {

		Cliente cliente = new Cliente("123A", "outeiro, María", "maria@abcd.net");

		System.out.println(cliente.toString());
	}

}
