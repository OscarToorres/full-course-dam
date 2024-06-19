package ejercicio01;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class FuncionalidadURL {

	public static void main(String[] args) throws IOException {
		URL url = null;
		URLConnection conexion = null;
		try {
			String protocolo = "http";
			String ruta = "docs.oracle.com";
			Integer puerto = 80;
			String fichero = "/javase/7";
			url = new URL(protocolo,ruta,puerto,fichero);
			Visualizar(url);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void Visualizar(URL url) throws IOException {
		FileWriter fw = new FileWriter("fichero.txt");
		fw.write(url.toString());
		fw.write("URL completa: " + url.toString() + "\n");
		fw.write("Protocolo -> getProtocol(): " + url.getProtocol() + "\n");
		fw.write("Nombre de la maquina -> getHost(): " + url.getHost() + "\n");
		fw.write("Puerto -> getPort(): " + url.getPort() + "\n");
		fw.write("Fichero -> getFile(): " + url.getFile() + "\n");
		fw.write("Informacion del Usuario -> getUserInfo(): " + url.getUserInfo() + "\n");
		fw.write("Ruta -> getPath(): " + url.getPath() + "\n");
		fw.write("Autoridad de url -> getAuthority(): " + url.getAuthority() + "\n");
		fw.write("Consulta -> getQuery(): " + url.getQuery() + "\n");
		fw.close();
	}
}