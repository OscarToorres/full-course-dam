package compilador35_40;

import java.util.Scanner;

import misClases.avaliacion1.CSerie;

public class compi40 {

	/*
	 * Lo que se esta haciendo en este metodo es utilisar dos calses diferentes en
	 * dos paquetes diferentes por lo tanto hay que importar la clase del otro
	 * paquete para poder usarla en conjunto con esta clase. Para ello la otra clase
	 * deberá tener los metodos en publico. Por otro lado tambien queremos que en
	 * esta clase se metan las variables con el Scanner y despues se usen en la otra
	 * clase con el metodo que queramos usar. Para ello hay que adjuntar las
	 * variables que queramos usar tanto detro del metodo de la otra clase como en
	 * esta.
	 */
	
	public static void main(String[] args) {

		CSerie serie = new CSerie();
		Scanner teclado = new Scanner(System.in);
		int i;
		int i2;

		System.out.println("El numero A será menor que el numero B");
		System.out.print("Dame el numero A: ");
		i = teclado.nextInt();
		System.out.print("Dame el numero B: ");
		i2 = teclado.nextInt();
		serie.MuestraB_A(i, i2);
		teclado.close();
	}
}