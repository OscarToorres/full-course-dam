package pizarra37_42;

import misClases.avaliacion1.CNotas;

public class piza42 {

	public static void main(String[] args) {
		CNotas MiOrdenador = new CNotas();
		float media;
		
		MiOrdenador.mostraNotas();
		media = MiOrdenador.dameMedia();
		System.out.println("=====================");
		System.out.println("Nota Media: " + media);
	}
}