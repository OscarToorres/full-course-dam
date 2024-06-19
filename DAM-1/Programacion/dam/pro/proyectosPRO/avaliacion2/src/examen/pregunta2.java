package examen;

import java.io.IOException;

import misClases.avaliacion2.CCadena;

public class pregunta2 {

	public static void main(String[] args) throws IOException {

		CCadena cadena = new CCadena();

		System.out.print("Dame Cadena: ");
		cadena.recolleCadena();
		cadena.eliminaVocalesEnCadena();
		cadena.amosaCadena();

	}
}
