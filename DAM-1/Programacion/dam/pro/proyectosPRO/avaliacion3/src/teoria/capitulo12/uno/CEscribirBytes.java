package teoria.capitulo12.uno;

import java.io.FileOutputStream;
import java.io.IOException;

public class CEscribirBytes {

	public static void main(String[] args) {

		FileOutputStream fs = null;
		byte[] buffer = new byte[81];
		int nbytes;

		try {
			System.out.println("Escriba el texto que desea almacenar en el fichero:");
			nbytes = System.in.read(buffer);
			fs = new FileOutputStream("texto.txt");
			fs.write(buffer, 0, nbytes);
			if (fs != null) 
				fs.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				//  Cerrar el fichero
				if (fs != null)
					fs.close();
			} catch (IOException e) {
				System.out.println("Error: " + e.toString());
			}
		}
	}

}
