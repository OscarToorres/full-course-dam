package sockets3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class User {
	public static void main(String args[]) throws Exception {

		Socket s = new Socket("localhost", 6666);
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Server says: " + din.readUTF());

		String str = br.readLine();
		dout.writeUTF(str);
		dout.flush();

		dout.close();
		s.close();
	}
}