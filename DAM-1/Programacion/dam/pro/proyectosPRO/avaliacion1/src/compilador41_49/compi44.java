package compilador41_49;

import java.io.IOException;

public class compi44 {

	public static void main(String[] args) throws IOException {
		char texto;
		int i = 0;
		
		System.out.print(">");
		texto = (char) System.in.read();
		while (texto != '\r') {
			System.out.print(texto);
			texto = (char) System.in.read();
				i++;
			}
		System.out.println();
		System.out.println("Teclas pulsadas: " + i);

	}
}
