package pruebas;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Ejemplo1URL {

	public static void main(String[] args) {
		URL url;
		try {

			System.out.println("Constructor simple par auna URL:");
			url = new URL("http://docs.oracle.com/");
			Visualizar(url);

			System.out.println("Otro constructor simple para una URL:");
			url = new URL("http://www.circuitodejerez.com/index.php?id=196");
			Visualizar(url);

			System.out.println("Const. para protocolo +URL +directorio:");
			url = new URL("http","docs.oracle.com", "/javase/7");
			Visualizar(url);

			System.out.println("Constructor para protocolo + URL + puerto + directorio:");
			url = new URL("http","docs.oracle.com",80, "/javase/7");
			Visualizar(url);

			System.out.println("Constructor para un objeto URL y un directorio:");
			URL urlBase = new URL("http:\\docs.oracle.com");
			url = new URL(urlBase, "/javase/7/docs/api/java/net/URL.html");
			Visualizar(url);

		} catch (MalformedURLException e) {
			System.out.println(e);
		}
	}

	private static void Visualizar(URL url) {
		System.out.println("\tURL completa: " + url.toString());
		System.out.println("\tgetProtocol(): " + url.getProtocol());
		System.out.println("\tgetHost(): " + url.getHost());
		System.out.println("\tgetPort(): " + url.getPort());
		System.out.println("\tgetFile(): " + url.getFile());
		System.out.println("\tgetUserInfo(): " + url.getUserInfo());
		System.out.println("\tgetPath(): " + url.getPath());
		System.out.println("\tgetAuthority(): " + url.getAuthority());
		System.out.println("\tgetQuery(): " + url.getQuery());

	}
}
