package compilador41_49;

import java.io.IOException;

public class compi48 {

	public static void main(String[] args) throws IOException {
		char texto;
		
		System.out.print(">");
		texto = (char) System.in.read();
		
		while (texto != '\n') {
			if (texto == ' ')
				texto = '_';	
			System.out.print(texto);
			texto = (char) System.in.read();
			
		}
	}
}