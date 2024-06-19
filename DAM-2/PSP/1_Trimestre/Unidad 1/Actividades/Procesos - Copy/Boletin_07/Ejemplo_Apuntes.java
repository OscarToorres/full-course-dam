package Boletin_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo_Apuntes {
    
    public static void main (String [] args) {

        Runtime run = Runtime.getRuntime();

        //Con "CMD /C ____" ejecuta el comando especificado y termina
        //Con "CMD /K ____" ejecuta el comando especificado pero sigue activo
        String comando = "CMD /C DIR";
        Process proceso = null;

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

        //Hace que el proceso espere hast que el subproceso de Process finalice
        //WaitFor devuelve >> 0 bien -1 mal
        int exitVal = 0;
        try {
            exitVal = proceso.waitFor();
            System.out.println("Valor de salida: " + exitVal);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        //Esta parte de codigo recoge los errores cuando se introduce un comando erroneo
        //y los pinta por pantalla
        try {
            InputStream is = proceso.getErrorStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            //Lee linea a linea y lo va imprimiendo por pantalla
            String linea=null;
            while((linea=br.readLine())!=null) 
            System.out.println("ERROR>" + linea);

            br.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
