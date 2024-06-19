package teoria.capitulo03;

import misClases.teoria.CEcuacion;

public class CApEcuacion {

	public static void main(String[] args) {
		CEcuacion ecuacion = new CEcuacion();
		double resultado;

		ecuacion.Ecuacion(1, -3.2, 0, 7);
		resultado = ecuacion.ValorPara(1);
		System.out.println(resultado);
		resultado = ecuacion.ValorPara(1.5);
		System.out.println(resultado);
	}
}