package misClases.avaliacion2;

import java.io.IOException;

public class CRecursivo {

	private int[] vector = { 1, 3, 6, 2, 8, 7 };
	private char[] cadena = new char[40];

	public void amosa1_N(int n) {
		if (n > 1)
			amosa1_N(n - 1);
		System.out.print("    " + n);
	}

	public void amosaN_1(int n) {
		System.out.print("    " + n);
		if (n > 1)
			amosaN_1(n - 1);
	}

	public void amosaA_B(int a, int b) {
		System.out.print("    " + a);
		if (a < b)
			amosaA_B(a + 1, b);
	}

	public void amosaB_A(int a, int b) {
		System.out.print("    " + b);
		if (a < b)
			amosaB_A(a, b - 1);
	}

	public long factorial(long n) {
		long facto;
		if (n > 1L) {
			facto = n * this.factorial(n - 1L);
		} else {
			facto = 1L;
		}
		return facto;
	}

	public int suma1_N(int n) {
		int suma;
		if (n == 1)
			suma = n;
		else
			suma = n + suma1_N(n - 1);
		return suma;
	}

	public int sumaA_B(int a, int b) {
		int dato;
		if (a == b)
			dato = a;
		else
			dato = a + sumaA_B(a + 1, b);
		return dato;
	}

	public void amosa(int n) {
		if (n > 1)
			amosa(n - 1);
		System.out.print("    " + vector[n - 1]);
	}

	public void amosaReves(int n) {
		System.out.print(" " + vector[n - 1]);
		if (n > 1)
			amosaReves(n - 1);
	}

	public void recolleCadena() throws IOException {
		System.out.print("Dame cadena: ");
		char letra = (char) System.in.read();
		for (int i = 0; letra != '\r'; letra = (char) System.in.read(), i++)
			this.cadena[i] = letra;
	}

	public void amosaRevesCadena(int n) {

		if (cadena[n] != '\0') {
			amosaRevesCadena(n + 1);
			System.out.print(cadena[n]);
		}
	}

	public void amosaSenDixitos(int n) {
		if (cadena[n] != '\0') {
			if (cadena[n] < '0' || cadena[n] > '9')
				System.out.print(cadena[n]);
			amosaSenDixitos(n + 1);
		}
	}

	public int total() {
		int i = 0;
		while (cadena[i] != '\0') {
			i++;
		}
		return i--;
	}

	public void amosaDixitosDuplicados(int longitud) {

		if (longitud > 0) {
			amosaDixitosDuplicados(longitud - 1);
			System.out.print(cadena[longitud - 1]);
			if (cadena[longitud - 1] >= '0' && cadena[longitud - 1] <= '9')
				System.out.print(cadena[longitud - 1]);
		}
	}

	public void amosa467DuplicadosReves(final int n) {
		if(this.cadena[n] != '\0') {
			this.amosa467DuplicadosReves(n + 1);
			System.out.print(this.cadena[n]);
			if (this.cadena[n] == '4' || this.cadena[n] == '6' || this.cadena[n] == '7')
				System.out.print(this.cadena[n]);
				
		}
		
	}
}