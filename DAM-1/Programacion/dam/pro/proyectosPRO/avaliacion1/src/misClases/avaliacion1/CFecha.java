package misClases.avaliacion1;

import java.util.Scanner;

public class CFecha {

	private int dia;
	private int mes;
	private int a�o;
	private Scanner teclado = new java.util.Scanner(System.in);
	
	public void recogeDia() {
		System.out.print("Introduzca un dia: ");
		dia = teclado.nextInt();
		while (dia <= 0 || dia >= 32 ) {
			System.out.print("Introduzca un dia: ");
			dia = teclado.nextInt();
		}
	}
	
	public void recogeMes() {
		System.out.print("Introduzca un mes: ");
		mes = teclado.nextInt();
		while (mes <= 0 || mes >= 13 ) {
			System.out.print("Introduzca un mes: ");
			dia = teclado.nextInt();
		}
	}
	
	public void recogeA�o() {
		System.out.print("Introduzca un a�o: ");
		a�o = teclado.nextInt();
		while (a�o <= 1989 || mes >= 2011 ) {
			System.out.print("Introduzca un a�o: ");
			dia = teclado.nextInt();
		}
	}
	
	public void amosaResultado() {
		System.out.println("Resultado: " + dia + "/" + mes + "/" + a�o);
	}
	
}
