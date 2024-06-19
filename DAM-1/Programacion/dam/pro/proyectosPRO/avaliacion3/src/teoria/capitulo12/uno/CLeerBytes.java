package teoria.capitulo12.uno;

import java.io.FileInputStream;
import java.io.IOException;

public class CLeerBytes {

	public static void main(String[] args) {
		
		FileInputStream fe = null;
		byte[] buffer = new byte[81];
		int nbytes;
		
		try {
			fe = new FileInputStream("texto.txt");
			nbytes = fe.read(buffer, 0, 81);
			String srt = new String(buffer, 0, nbytes); 
			System.out.println(srt);
		}catch(IOException e) {
			System.out.println("Error: " + e.toString());
		} finally {
			try {
				//cerrar el fichero
				if (fe != null)
					fe.close();
			} catch(IOException e) {
				System.out.println("Error: " + e.toString());
			}
		}
	}

}
