package compilador09_16;

import java.util.Scanner;

public class compi14 {
	public static void main(String[] ar) {
		int n1;
		Scanner teclado = new java.util.Scanner(System.in);
		
	
		System.out.print("Dame un entero entre 1 y 99: ");
		n1 = teclado.nextInt();
		//Aqui convertimos el n1 a caracteres con el String.valueOf(n1) y le asignamos un nuevo nombre, en este caso n2
	    String n2 = String.valueOf(n1);
	    teclado.close();
	    
	    /*Comprobacion para saber que longitud tiene el valor de n2 y que la transformacion está funcionando
	    System.out.println(n2);
	    System.out.println(n2.length());
		*/
		 
		 //length es para saber la longitud que tiene el valor n2
        if (n2.length() <=1) {
    		System.out.println("Tiene UN digito");
        }
        if (n2.length() > 1) {
    		System.out.println("Tiene DOS digitos");
        }	
	}
}