package boletin_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio_03 {
	
    public static void main (String [] args) {
        String ping = "8.8.8.8";
    	String comando = "ping " + ping;
        Process proceso = null;
        Runtime run = Runtime.getRuntime();

        try { 
            proceso = run.exec(comando); //Con solo esta linea de comando ejecutariamos el programa en cuestion

            //Leemos el comando que se envio a la consola y se guarda
            InputStream is = proceso.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            //Mostramos la salida del comando que se mando
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        
        } catch (IOException ex) {
            System.out.println("Error en: " + comando);
            ex.printStackTrace();
        }
}
}