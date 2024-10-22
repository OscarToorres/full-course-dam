package sockets4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.Date;

public class UserComparacion {
	public static void main(String args[]) throws Exception {
		Fechas fecha = new Fechas();
		DatagramSocket ds = new DatagramSocket(3000);
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, 1024);
		
		
		try {
			ds.setSoTimeout(5000);;
			ds.receive(dp);
			String str = new String(dp.getData(), 0, dp.getLength());
			Date d = new Date();
			String user = fecha.dateToString(d);
			Date serverTime = fecha.stringToDate(str);
			Date userTime = fecha.stringToDate(user);
			
			long duration = userTime.getTime() - serverTime.getTime();
			System.out.println("Timepo transcurrido: "+ duration +" millisegundos");
			
		} catch (Exception e) {
			System.out.print("No se obtuvo respuesta");
		}

		ds.close();
	}
}