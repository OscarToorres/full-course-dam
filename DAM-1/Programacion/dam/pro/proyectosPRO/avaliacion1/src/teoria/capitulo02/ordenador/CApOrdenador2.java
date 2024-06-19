package teoria.capitulo02.ordenador;

public class CApOrdenador2 {

	public static void main (String[] args)
	{
		COrdenador2 MiOrdenador = new COrdenador2();
		MiOrdenador.Marca = "Ast";
		MiOrdenador.Procesador = "Intel Pentium";
		MiOrdenador.Pantalla = "TFT";
		MiOrdenador.EncenderOrdenador();
		MiOrdenador.Estado();
		MiOrdenador.ApagarOrdenador();
		MiOrdenador.Estado();
	}

}