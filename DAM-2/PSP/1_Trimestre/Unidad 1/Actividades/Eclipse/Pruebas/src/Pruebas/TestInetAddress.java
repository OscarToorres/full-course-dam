package pruebas;

import java.net.*;

public class TestInetAddress {

	public static void main(String[] args) {
		InetAddress dir = null;
		System.out.println("=================================");
		System.out.println("SALIDA PARA LOCALHOST");
		try{
			//LOCALHOST
			dir = InetAddress.getByName("localhost");
			pruebaMetodos(dir);
			
			System.out.println("=================================");
			System.out.println("SALIDA PARA UNA URL");
			dir = InetAddress.getByName("ADA-VM.olimpia.ga");
			pruebaMetodos(dir);
			
			System.out.println(" \tDIRECCIONES IP PARA: " + dir.getHostName());
			InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
			for (int i = 0; i < direcciones.length; i++) {
				System.out.println("\t\t" + direcciones[i].toString());
			System.out.println("=====================================");
			}
			}catch (UnknownHostException el) {
			el.printStackTrace();
		}
	}
	
	private static void pruebaMetodos(InetAddress dir) {
		System.out.println("\tMetodo getByName(): " + dir);
		InetAddress dir2;
		try {
			dir2 = InetAddress.getLocalHost();
			System.out.println("\tMetodo getLocalHost: " + dir2);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.out.println("\tMetodo getHostName(): " + dir.getHostName());
		System.out.println("\tMetodo getHostAdderss(): " + dir.getHostAddress());
		System.out.println("\tMetodo toString(): " + dir.toString());
		System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());
	}
	
}
