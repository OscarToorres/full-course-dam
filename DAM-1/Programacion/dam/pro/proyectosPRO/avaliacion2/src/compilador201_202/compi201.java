package compilador201_202;

import misClases.avaliacion2.CDameDato;

public class compi201 {

	public static void main(String[] args) {
		CDameDato Respuesta = new CDameDato();
		int numero = 0;
		
		numero = Respuesta.menu();
		while(numero != 4) {
			
			switch (numero) {
			case 1:
				Respuesta.recogerDatoEntero();
				break;
			case 2:
				Respuesta.recogerDatoFloat();
				break;
			case 3:
				Respuesta.recogerDatoString();
				break;
			default:
				System.out.println("OPCION Erronea");
				break;
			}
		numero = Respuesta.menu();
		}
		
		System.out.println("FINAL");
	}
}