package pruebas_examen_clases;

public class ClasePruebas {
	
	public void amosaB_AsumaAimpares (int a, int b) {
		while (b >= a) {
			if ( b % 2 == 0) 
				System.out.print(b);
			System.out.print(" " + a + "+" + b + " " );
			b--;
		}
	}
	}
