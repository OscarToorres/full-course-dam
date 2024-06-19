package compilador41_49;

import java.io.IOException;

public class compi43 {

	public static void main(String[] args) throws IOException {

		char texto;

		System.out.print(">");
		texto = (char) System.in.read();
		while (texto != '\n') {
			System.out.println(texto);
			texto = (char) System.in.read();
		}
	}
}