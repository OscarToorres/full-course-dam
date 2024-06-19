package rectangulo;

import java.util.Scanner;

public class Rectangulo {

	private final static String LADO1 = "Lado a = ";
	private final static String LADO2 = "Lado b = ";
	private final static String SALIR = "Salir";
	private final static String OPCIONES_CALCULO = "Opción\\r\\n\\t1. Perímetro\\r\\n\\t2. Superficie\\r\\n\\t0. Saír";

	public static int inserirDato(String mensaxe) {
		System.out.println(mensaxe);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	private static int perimetro(int a, int b) {
		return a * 2 + b * 2;
	}

	private static int superficie(int a, int b) {
		return a * b;
	}

	private static void resultado(int valor, String mensaxe) {
		System.out.print(mensaxe + "=" + valor);
	}

	private static void menu(int a, int b, int opcion) {
		int perimetro;
		int superficie;
		
		if (opcion == 1) {
			perimetro = perimetro(a, b);
			resultado(perimetro, "Perimetro p");
		} else if (opcion == 2) {
			superficie = superficie(a, b);
			resultado(superficie, "Superficie s");
		} else
			System.out.println(SALIR);
	}

	public static void main(String[] args) {

		int a = inserirDato(LADO1);
		int b = inserirDato(LADO2);
		int opcion = inserirDato(OPCIONES_CALCULO);
		menu(a, b, opcion);

	}
}
