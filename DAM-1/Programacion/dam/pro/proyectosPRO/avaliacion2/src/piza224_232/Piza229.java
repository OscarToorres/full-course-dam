package piza224_232;

import misClases.avaliacion2.CRecursivo;

public class Piza229 {

	public static void main(String[] args) {
		
        CRecursivo recursivo = new CRecursivo();
		int n = 8;
        int suma = recursivo.suma1_N(n);
        System.out.print("Suma desde 1 hasta " + n + ": " + suma);
	}

}