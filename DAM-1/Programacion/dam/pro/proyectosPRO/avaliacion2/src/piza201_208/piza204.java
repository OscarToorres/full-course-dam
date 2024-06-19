package piza201_208;

import java.io.IOException;

import misClases.avaliacion2.CCadena;

public class piza204 {

	public static void main(String[] args) throws IOException {

		CCadena cadena = new CCadena();
		
		System.out.print("Dame cadena: ");
		cadena.recolleCadena();
		cadena.invierteCadena();
		cadena.amosaCadena();
	}

}
