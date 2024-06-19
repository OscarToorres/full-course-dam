package misClases.avaliacion1;

import java.util.Scanner;

public class CFecha {

	private int dia;
	private int mes;
	private int año;
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
	
	public void recogeAño() {
		System.out.print("Introduzca un año: ");
		año = teclado.nextInt();
		while (año <= 1989 || mes >= 2011 ) {
			System.out.print("Introduzca un año: ");
			dia = teclado.nextInt();
		}
	}
	
	public void amosaResultado() {
		System.out.println("Resultado: " + dia + "/" + mes + "/" + año);
	}
	
}
