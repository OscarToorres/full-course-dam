package Boletin_07;

import java.io.File;
import java.io.IOException;

public class Ejercicio_02 {
    
    public static void main (String [] args) {

        //Aqui se crea el nombre del proceso que se quiere ejecutar y el comando que se le manda
        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR");

        //Creacion de dos ficheros
        File fOut = new File("D:\\Prueba\\salida.txt");
        File fErr = new File("D:\\Prueba\\error.txt");

        //Aqui se indica a donde se quiere mandar la salida del proceso
        //En caso de qeu no de error va por el rpimero y sino por el segundo
        pb.redirectOutput(fOut);
        pb.redirectError(fErr);

        //Se inicia el proceso
        try {
            pb.start();
        } catch (IOException ex) {
            System.out.println("Excepcion de E/S!!");
            System.exit(-1);
        }
    }
}
