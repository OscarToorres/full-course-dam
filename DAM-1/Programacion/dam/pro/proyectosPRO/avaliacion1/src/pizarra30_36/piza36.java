package pizarra30_36;

import java.io.IOException;

public class piza36 {

	public static void main(String[] args) throws IOException {
		char vocal;

		System.out.print("Dame un VOCAL minuscula: ");
		vocal = (char) System.in.read();
		System.in.read();
		System.in.read();

		while (vocal == 'a' || vocal == 'e' || vocal == 'i' || vocal == 'o' || vocal == 'u') {
			System.out.println("CORRECTO es VOCAL minuscula: " + vocal);
			System.out.print("Dame un VOCAL minuscula: ");
			vocal = (char) System.in.read();
			System.in.read();
			System.in.read();
		}
		System.out.println("INCORRECTO no es VOCAL minuscula: " + vocal);
	}
}