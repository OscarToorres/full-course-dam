package teoria.capitulo04;

import java.util.Scanner;

import misClases.teoria.CPrueba;

public class CApGrados {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		CPrueba prueba = new CPrueba();
		float a;
		
		System.out.print("Dame Grados Centigrados: ");
		a = teclado.nextFloat();
		prueba.RecogeGrados(a);
		prueba.AmosaGrados(a);
		teclado.close();
	}
}