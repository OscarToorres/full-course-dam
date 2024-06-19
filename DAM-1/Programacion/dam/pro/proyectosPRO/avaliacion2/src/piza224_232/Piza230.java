package piza224_232;

import misClases.avaliacion2.CRecursivo;

public class Piza230 {
	
	public static void main(String[] args) {
		
		CRecursivo recursivo = new CRecursivo();
		int a, b, suma;
		a = 8;
		b = 13;
		suma = recursivo.sumaA_B(a, b);
		System.out.print("Suma desde " + a + " hasta " + b + ": " + suma);
	}
}
