package compilador305_307;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import misClases.utilidades.Leer;

public class compi305 {

	public static void main(String[] args) {
		File fichero;
		FileReader fe = null;
		String nombreFichero;
		int caracter;

		do {
			System.out.print("Nombre del fichero: ");
			nombreFichero = Leer.datoString();
			fichero = new File(nombreFichero);
		} while (!fichero.exists());

		try {
			fe = new FileReader(fichero);
			while ((caracter = fe.read()) != -1)
				System.out.print((char) caracter);
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				if (fe != null)
					fe.close();
			} catch (IOException e) {
				System.out.println("Error: " + e.toString());
			}
		}
	}
}