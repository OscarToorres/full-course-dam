package compilador41_49;

import java.io.IOException;

public class compi49 {

	public static void main(String[] args) throws IOException {
		char texto;

		System.out.print(">");
		texto = (char) System.in.read();
		System.out.print("((");

		while (texto != '\r') {
			if (texto == ' ')
				texto = '_';
			System.out.print(texto);
			texto = (char) System.in.read();
			if (texto == '\r')
				System.out.print("))");
		}
	}
}