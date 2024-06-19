package Boletin_07;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio_01 {

    public static void main (String [] args) {
        String comando = "java MostrarNome Pablo";
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Comprobacion de error
        int exitVal;
        try {
            exitVal = proceso.waitFor();
            System.out.println("Valor de salida: " + exitVal);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
