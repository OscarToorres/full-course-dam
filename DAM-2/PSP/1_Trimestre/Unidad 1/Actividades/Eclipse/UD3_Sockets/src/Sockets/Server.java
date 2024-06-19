package sockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String mensage = (String)dis.readUTF();
			System.out.println("mensage = " + mensage);
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
