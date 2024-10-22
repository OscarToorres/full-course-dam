package teoria.capitulo12.uno;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CApByteArray {

	public static void main(String[] args) throws IOException {
		byte[] m1 = new byte[80];
		byte[] m2 = new byte[80];
		int car, i = 0;

		// Almacenar datos en la matriz m1
		for (car = 'a'; car <= 'z'; car++)
			m1[i++] = (byte) car;

		// Abrir un flujo, flujoE, desde la matriz m1
		ByteArrayInputStream flujoE = new ByteArrayInputStream(m1);
		// Abrir un flujjo , flujoS, hacia una matriz temporal
		ByteArrayOutputStream flujoS = new ByteArrayOutputStream();
		
		try {
			// Leer de flujoE y escribir en flujoS
			while ((car = flujoE.read()) != -1)
				flujoS.write(car);

			// Copiar en m2 los datos enviados al flujoS
			m2 = flujoS.toByteArray();
			System.out.println(new String (m2));
		} finally {
			// cerrar los flujos
			flujoE.close();
			flujoS.close();
		}
	}
}