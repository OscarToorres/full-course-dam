package preparatorios.ejem02;

public class ejemplo2 {

	public static void main(String[] args) {
		CLibreria libreria;
		int numero;
		int codigo;

		libreria = new CLibreria();
		do {
			numero=libreria.dameOpcion();
			switch (numero) {
			case 1:
				libreria.llenar();
				System.out.println("Libreria LLENA");
				break;
			case 2:
				libreria.vaciar();
				System.out.println("Libreria VACIA");
				break;
			case 3:
				libreria.mostrar();
				break;
			case 4:
				System.out.print("Dame código de libro: ");
				codigo = Leer.datoInt();
				libreria.mostrarLibro(codigo);
				break;
			case 5:
				System.out.print("Dame código de libro: ");
				codigo = Leer.datoInt();
				libreria.eliminarLibro(codigo);
				break;
			case 6:
				System.out.println("FINAL");
				break;
			default:
				System.out.println("OPCION Erronea");
				break;
			}
		} while (numero != 6);
	}
}
