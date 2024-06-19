package practicas1_4;

public class practica2 {

	public static void main(String[] args) {
		 int codigo = 32;
	        char letra = (char)codigo;
	        int conta = 0;
	        while (codigo <= 126) {
	            if (codigo < 100) {
	                System.out.print("  " + codigo + "   " + letra);
	            }
	            else {
	                System.out.print(" " + codigo + "   " + letra);
	            }
	            letra = (char)(++codigo);
	            if (++conta == 10) {
	                System.out.println();
	                conta = 0;
	            }
	        }
	    }
	}