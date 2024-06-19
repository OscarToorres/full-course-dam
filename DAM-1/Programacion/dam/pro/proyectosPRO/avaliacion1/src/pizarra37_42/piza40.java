package pizarra37_42;

import misClases.avaliacion1.CNotas;

public class piza40 {

	public static void main(String[] args) {
		CNotas MiOrdenador = new CNotas();
		int indiceMayor;
		float notaMayor;
		
		MiOrdenador.mostraNotas();
		indiceMayor = MiOrdenador.dameMayor();
		notaMayor = MiOrdenador.dameNota(indiceMayor);
		System.out.println();
		System.out.println("Alumno con MAYOR nota");
		System.out.println("=====================");
		System.out.println("Alumno " + (indiceMayor + 1) + ": " + notaMayor );
	}

}
