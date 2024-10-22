package sockets3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;

public class Server {

	public static void main(String args[]) throws Exception {
		ServerSocket ss = new ServerSocket(6666);
		Socket s = ss.accept();
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());

		LocalTime hora = java.time.LocalTime.now();
		LocalDate fecha = java.time.LocalDate.now();
	
		dout.writeUTF("Que quieres mostrar, fecha o hora actual?(fecha -> 1 hora -> 2): ");
		dout.flush();
		String respuestaUser = din.readUTF();
		if ("1".equals(respuestaUser)) {
			dout.writeUTF(fecha.toString());
			dout.flush();
		}
		if ("2".equals(respuestaUser)) {
			dout.writeUTF(hora.toString());
			dout.flush();
		}
				
		din.close();
		s.close();
		ss.close();
	}
}