package sockets4;

import java.net.*;


public class User {
	public static void main(String args[]) throws Exception {

		DatagramSocket ds = new DatagramSocket(3000);
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, 1024);
		try {
			ds.setSoTimeout(5000);
			ds.receive(dp);
		}catch (Exception e) {
			System.out.print("No se obtuvo respuesta");
		}
		String str = new String(dp.getData(), 0, dp.getLength());
		System.out.println(str);
		ds.close();
	}
}