package sockets3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFichero {
	public static void main(String args[]) throws Exception {
		ServerSocket ss = new ServerSocket(6666);
		Socket s = ss.accept();
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());

		String contenido = "";
		FileReader fr = new FileReader("I:\\DAM2\\PSP\\1_Trimestre\\Unidad 1\\Actividades\\Eclipse\\UD3_Sockets\\leeme.txt");
		BufferedReader br = new BufferedReader(fr);
		do {
			contenido = br.readLine();
		} while (fr.read() != -1);
		
		dout.writeUTF(contenido);
		dout.flush();
		
		din.close();
		s.close();
		ss.close();
	}
}