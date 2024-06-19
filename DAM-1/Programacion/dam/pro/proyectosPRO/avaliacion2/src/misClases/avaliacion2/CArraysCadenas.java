package misClases.avaliacion2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CArraysCadenas {

	private String [] cadena = new String[7];
	Scanner teclado = new java.util.Scanner(System.in);
	
	public void inicializa() {
		cadena[0] = "Lunes";
		cadena[1] = "Martes";
		cadena[2] = "Miercoles";
		cadena[3] = "Jueves";
		cadena[4] = "Viernes";
		cadena[5] = "Sabado";
		cadena[6] = "Domingo";
	}
	
	public void amosa() {
		System.out.println("  ARRAY de Cadenas");
		System.out.println("  ================");
		for (int i = 0; i < this.cadena.length; System.out.print("  " + cadena[i]), i++) {}
	}
	
	public int menu () {
		int opcion;
		
		System.out.println("  M E N U");
		System.out.println("  =======");
		System.out.println(" 1.- INICIALIZA Array de Cadenas");
		System.out.println(" 2.- AMOSA Array");
		System.out.println(" 3.- ORDENA Ascendentemente");
		System.out.println(" 4.- ORDENA Descendentemente");
		System.out.println(" 5.- FINAL");
		
		System.out.print("Pulsa opción: ");
		opcion = teclado.nextInt();
		return opcion;
	}
	
	   public void ordenaAscendente() {
		   Arrays.sort(cadena); 
		
		   /*
	        if (this.cadena[0] == null) {
	            return;
	        }
	        for (int i = 1; i <= this.cadena.length - 1; ++i) {
	            for (int j = this.cadena.length - 1; j >= i; --j) {
	                if (this.cadena[j - 1].compareTo(this.cadena[j]) > 0) {
	                    final String dato = this.cadena[j - 1];
	                    this.cadena[j - 1] = this.cadena[j];
	                    this.cadena[j] = dato;
	                }
	            }
	        }
	        */
	    }
	   
	    public void ordenaDescendente() {
			   Arrays.sort(cadena,Collections.reverseOrder());
			   /*
	        if (this.cadena[0] == null) {
	            return;
	        }
	        for (int i = 1; i <= this.cadena.length - 1; ++i) {
	            for (int j = this.cadena.length - 1; j >= i; --j) {
	                if (this.cadena[j - 1].compareTo(this.cadena[j]) < 0) {
	                    final String dato = this.cadena[j - 1];
	                    this.cadena[j - 1] = this.cadena[j];
	                    this.cadena[j] = dato;
	                }
	            }
	        }
	        */
	    }
	
	
	
	
	
}
