package compilador203_205;

import java.util.Scanner;

import misClases.avaliacion2.CVector;

public class compi205 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		int a, numero;
		CVector mostrar = new CVector();

		do {
		mostrar.menu();
		a = teclado.nextInt();
		switch (a) {
			case 1:
				mostrar.IniciarVectorEnteros();
				break;
			case 2:
				mostrar.mostrarVectores();
				break;
			case 3:
				System.out.print(" Dame enteiro a INSERTAR: ");
				numero = teclado.nextInt();
				mostrar.insertaVector(numero);
				break;
			case 4:
				System.out.print(" Dame enteiro a ELIMINAR: ");
				numero = teclado.nextInt();
				mostrar.eliminaVector(numero);
				break;
			case 5:
				System.out.println("FINAL");
				break;
			default:
				System.out.println("OPCION Erronea");
				break;
		}
		}while (a != 5);
	teclado.close();
	}

}
