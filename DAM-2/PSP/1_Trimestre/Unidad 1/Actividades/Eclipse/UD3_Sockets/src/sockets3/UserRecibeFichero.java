package sockets3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class UserRecibeFichero {
	public static void main(String args[]) throws Exception {

		Socket s = new Socket("localhost", 6666);
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());

		String str2 = din.readUTF();
		System.out.println("Server says: " + str2);

		dout.close();
		din.close();
		s.close();
	}
}