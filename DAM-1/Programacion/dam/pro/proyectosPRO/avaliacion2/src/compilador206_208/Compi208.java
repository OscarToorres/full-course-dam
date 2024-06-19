package compilador206_208;

import java.util.Scanner;

import misClases.avaliacion2.CVectorAleatorio;

public class Compi208 {

	public static void main(String[] args) {
		int a = 0;
		Scanner teclado = new java.util.Scanner(System.in);
		CVectorAleatorio vector = new CVectorAleatorio();
		
		do {
			a = vector.menu();
			switch (a) {
				case 1:
					vector.inicializarVectoresAleatorios();
					System.out.println("");
					System.out.println("Vector INICIALIZADO");
					break;
				case 2:
					vector.amosaVectores();
					break;
				case 3:
					vector.ordenaAscendente();
					vector.amosaVectores();
					break;
				case 4:
					vector.ordenaDescendentemente();
					vector.amosaVectores();
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
