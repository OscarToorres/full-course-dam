package compilador41_49;

import java.io.IOException;

public class compi46 {

	public static void main(String[] args) throws IOException{
		
		char texto;
		
		System.out.print(">");
		texto = (char) System.in.read();
		while (texto != '\r') {
			System.out.print((char)(texto - 3));
			texto = (char) System.in.read();
		}
	}
}