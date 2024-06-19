package compilador41_49;

import java.io.IOException;

public class compi41 {

	public static void main(String[] args) throws IOException {
		char texto;
		
		System.out.print(">");
		texto = (char) System.in.read();
		while (texto != '\n') {
			System.out.print(texto);
			texto = (char) System.in.read();
		}
	}
} 