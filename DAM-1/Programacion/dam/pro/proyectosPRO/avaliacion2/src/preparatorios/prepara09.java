package preparatorios;

import java.io.IOException;

import misClases.avaliacion2.CRecursivo;

public class prepara09 {

	public static void main(String[] args) throws IOException {

		CRecursivo recursivo = new CRecursivo();
		recursivo.recolleCadena();
		recursivo.amosaDixitosDuplicados(recursivo.total());
	
		
	}

}
