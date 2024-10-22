package sockets4;

import java.net.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Server {

	public static void main(String args[]) throws Exception {
		Fechas fechas = new Fechas();
		DatagramSocket ds = new DatagramSocket();
		InetAddress ip = InetAddress.getByName("127.0.0.1");
		byte[] buf = new byte[1024];

		Date d = new Date();
		String serverFecha = fechas.dateToString(d);
		
		String strSend = serverFecha;

		DatagramPacket dp = new DatagramPacket(strSend.getBytes(), strSend.length(), ip, 3000);
		ds.send(dp);
		ds.close();
	}
}