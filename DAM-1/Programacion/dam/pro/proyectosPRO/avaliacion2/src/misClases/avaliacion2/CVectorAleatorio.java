package misClases.avaliacion2;

import java.util.Scanner;

public class CVectorAleatorio {

	private int[] vector = new int[10];
	static final int MINIMO = 30;
	static final int MAXIMO = 90;
	Scanner teclado = new java.util.Scanner(System.in);

	public void inicializarVectoresAleatorios() {
		int i = 0;
		while (i < 10) {
			vector[i] = (int) (Math.random() * (MAXIMO - MINIMO)) + MINIMO;
			i++;
		}
	}

	public void amosaVectores() {
		System.out.println("   VECTOR de Enteiros");
		System.out.println("   ==================");
		for (int i = 0; i < 10; i++)
			System.out.print("      " + i);
		System.out.println("");
		for (int i = 0; i < 10; i++)
			System.out.print("     " + vector[i]);

	}

	public int menu() {
		int opcion;

		System.out.println("\n  M E N U");
		System.out.println("  =======");
		System.out.println(" 1.- INICIALIZA Array de Cadenas");
		System.out.println(" 2.- AMOSA Array");
		System.out.println(" 3.- ORDENA Ascendentemente");
		System.out.println(" 4.- ORDENA Descendentemente");
		System.out.println(" 5.- FINAL");

		opcion = teclado.nextInt();
		return opcion;
	}

	public void ordenaAscendente() {
		int i = 0, n = 10, j = 0, dato = 0;

		for (i = 1; i <= n - 1; i++)
			for (j = n - 1; j >= i; j--)
				if (vector[j - 1] > vector[j]) {
					dato = vector[j - 1];
					vector[j - 1] = vector[j];
					vector[j] = dato;
				}
	}

	public void ordenaDescendentemente() {
		int i = 0, n = 10, j = 0, dato = 0;
		// "n" es la cantidad de vectores que hay, en este caso 10.
		// "i", "j", son contadortes que se emcargan de ir sumando el array.

		for (i = 1; i <= n - 1; i++)
			for (j = n - 1; j >= i; j--)
				if (vector[j - 1] < vector[j]) {
					dato = vector[j - 1];
					vector[j - 1] = vector[j];
					vector[j] = dato;
				}
	}
}
