package boletin_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aleatorios {

	public static void main(String[] args) {

		Runtime run = Runtime.getRuntime();
		Process proceso = null;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String linea = "";

		try {
			do {
				System.out.println("Introduca una línea");
				linea = br.readLine();
				System.out.println("Sigue leyendo");
				proceso = run.exec("java src/boletin_08/NumerosAleatorios.java");
				BufferedReader br2 = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
				System.out.println("Número aleatorio >> " + br2.readLine());
			} while (linea.compareTo("fin") != 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}