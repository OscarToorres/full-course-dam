package piza224_232;

import misClases.avaliacion2.CRecursivo;

public class Piza228 {

	public static void main(String[] args) {

		CRecursivo recursivo = new CRecursivo();
		long n;
		
		n = 5L;
        long facto = recursivo.factorial(n);
        System.out.print("Factorial de " + n + ": " + facto);
	}

}
