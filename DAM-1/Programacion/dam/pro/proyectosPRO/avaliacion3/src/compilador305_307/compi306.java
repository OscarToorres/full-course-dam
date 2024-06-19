package compilador305_307;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import misClases.utilidades.Leer;

public class compi306 {

	public static File asignaFichero(File fichero) {
		String nombreFichero;

		do {
			System.out.print("Nombre del fichero: ");
			nombreFichero = Leer.datoString();
			fichero = new File(nombreFichero);
		} while (!fichero.exists());
		return fichero;
	}

	public static void amosa(File fichero) {
		FileReader fe = null;
		int caracter;

		try {
			fe = new FileReader(fichero);
			while ((caracter = fe.read()) != -1)
				System.out.print((char) caracter);
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				// Cerrar el fichero
				if (fe != null)
					fe.close();
			} catch (IOException e) {
				System.out.println("Error: " + e.toString());
			}

		}

	}
	
	public static void main(String[] args) {
		File fichero = null;
		
		fichero = asignaFichero(fichero);
		amosa(fichero);
	}
}