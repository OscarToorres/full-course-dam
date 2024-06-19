package teoria.capitulo12.uno;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CEscribirCars {

	public static void main(String[] args) {
		
		FileWriter fs = null;
		byte[] buffer = new byte[81];
		int nbytes;
		String nombreFichero = null;
		File fichero = null;
		 
		try {
			System.out.println("Nombre del fichero: ");
			nbytes =System.in.read(buffer);
			nombreFichero = new String(buffer, 0, nbytes - 2);
			
			char resp = 's';
			if (fichero.exists()) {
				
				System.out.print("El fichero existe �desea sibreescribirlo? (s/n) ");
				resp = (char)System.in.read();
				// Saktar kis bytes no leidos del flujo in
				System.in.skip(System.in.available());
			} if(resp == 's') {
				System.out.println("Escriba el texto que desea almacenar en el fichero:");
				nbytes =System.in.read(buffer);
				String str = new String(buffer, 0, nbytes);
				fs = new FileWriter(fichero);
				fs.write(str, 0, str.length());
				
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		} finally {
		} try {
			// Cerrar el fichero
			if (fs != null)
				fs.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}
		
	}

}
