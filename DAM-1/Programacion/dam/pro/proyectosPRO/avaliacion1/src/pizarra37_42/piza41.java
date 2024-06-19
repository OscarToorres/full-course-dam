package pizarra37_42;

import misClases.avaliacion1.CNotas;

public class piza41 {

	public static void main(String[] args) {
		CNotas MiOrdenador = new CNotas();
		int indiceMenor;
		float notaMenor;
		
		MiOrdenador.mostraNotas();
		indiceMenor = MiOrdenador.dameMenor();
		notaMenor = MiOrdenador.dameNota(indiceMenor);
		System.out.println();
		System.out.println("Alumno con MENOR nota");
		System.out.println("=====================");
		System.out.println("Alumno " + (indiceMenor + 1)+ ": " + notaMenor);
	}

}
