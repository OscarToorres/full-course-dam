package preparatorios;

import java.io.IOException;

import misClases.avaliacion2.CRecursivo;

public class prepara05 {

	public static void main(String[] args) throws IOException {

		CRecursivo recursivo = new CRecursivo();
		int n = 0;
		recursivo.recolleCadena();
		recursivo.amosaSenDixitos(n);
	}
}
