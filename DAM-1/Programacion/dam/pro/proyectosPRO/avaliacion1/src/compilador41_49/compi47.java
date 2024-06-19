package compilador41_49;

import java.io.IOException;

public class compi47 {

	public static void main(String[] args) throws IOException {
		
		char texto;
		int i = 0;
		int j = 0;
		
		System.out.print(">");
		texto = (char) System.in.read();
		while (texto != '\n') {
			if (texto == ' ') 
				i++;
			else if (texto == 'a') 
				j++;
			System.out.print(texto);
			texto = (char) System.in.read();
			
		}
		System.out.println("Total espacios en blanco: " + i);
		System.out.println("Total letra 'a': " + j);
	}

}
