package compilador201_202;

import misClases.avaliacion2.CDameDato;

public class compi202 {

	public static void main(String[] args) {
		CDameDato Llama = new CDameDato();
		
		
			CDameDato Respuesta = new CDameDato();
			int numero = 0;
			
			do {
				numero = Respuesta.menu();
				
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
				case 4:
					System.out.println("FINAL");
					break;
				default:
					System.out.println("OPCION Erronea");
					break;
				}
			} while(numero != 4) ;
		}			
			
	}


