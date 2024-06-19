package teoria.capitulo02.ordenador;

public class CApOrdenador3 {

	public static void main (String[] args)
	{
		COrdenador3 MiOrdenador = new COrdenador3();
		MiOrdenador.Marca = "Ast";
		MiOrdenador.Procesador = "Intel Pentium";
		MiOrdenador.Pantalla = "TFT";
		MiOrdenador.EncenderOrdenador();
		MiOrdenador.Estado();
		MiOrdenador.ApagarOrdenador();
		MiOrdenador.Estado();
	}
}
