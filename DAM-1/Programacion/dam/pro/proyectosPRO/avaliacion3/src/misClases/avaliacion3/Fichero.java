package misClases.avaliacion3;

import java.util.StringTokenizer;
import java.io.StreamTokenizer;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import misClases.utilidades.Leer;
import java.io.File;

public class Fichero
{
    private File archivo;
    private String nombre;
    private String mensaje;
    
    public Fichero() {
        this.archivo = null;
        this.nombre = null;
        this.mensaje = "Nombre del fichero: ";
    }
    
    public void asignaFichero() {
        do {
            System.out.print(this.mensaje);
            this.nombre = Leer.datoString();
            this.archivo = new File(this.nombre);
        } while (!this.archivo.exists());
    }
    
    public void amosa() {
        FileReader fe = null;
        try {
            fe = new FileReader(this.archivo);
            int caracter;
            while ((caracter = fe.read()) != -1) {
                System.out.print((char)caracter);
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.toString());
            try {
                if (fe != null) {
                    fe.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
            return;
        }
        finally {
            try {
                if (fe != null) {
                    fe.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
        }
        try {
            if (fe != null) {
                fe.close();
            }
        }
        catch (IOException e2) {
            System.out.println("Error: " + e2.toString());
        }
    }
    
    public String dameNombre() {
        return this.nombre;
    }
    
    public void asignaFicheroLectura(final String men) {
        this.mensaje = men;
        do {
            System.out.print(this.mensaje);
            this.nombre = Leer.datoString();
            this.archivo = new File(this.nombre);
        } while (!this.archivo.exists());
    }
    
    public void asignaFicheroEscritura(final String men) {
        this.mensaje = men;
        System.out.print(this.mensaje);
        this.nombre = Leer.datoString();
        this.archivo = new File(this.nombre);
    }
    
    public void copia(final Fichero fDestino) {
        FileReader fe = null;
        FileWriter fs = null;
        try {
            fe = new FileReader(this.archivo);
            fs = new FileWriter(fDestino.archivo);
            int caracter;
            while ((caracter = fe.read()) != -1) {
                fs.write(caracter);
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.toString());
            try {
                if (fe != null) {
                    fe.close();
                }
                if (fs != null) {
                    fs.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
            return;
        }
        finally {
            try {
                if (fe != null) {
                    fe.close();
                }
                if (fs != null) {
                    fs.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
        }
        try {
            if (fe != null) {
                fe.close();
            }
            if (fs != null) {
                fs.close();
            }
        }
        catch (IOException e2) {
            System.out.println("Error: " + e2.toString());
        }
    }
    
    public void amosaFinal() {
        FileReader fe = null;
        try {
            fe = new FileReader(this.archivo);
            int i = 0;
            int caracter;
            while ((caracter = fe.read()) != -1) {
                if ((char)caracter != '\r' && (char)caracter != '\n') {
                    ++i;
                }
                else if ((char)caracter == '\r') {
                    System.out.print(" --->" + i);
                    i = 0;
                }
                System.out.print((char)caracter);
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.toString());
            try {
                if (fe != null) {
                    fe.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
            return;
        }
        finally {
            try {
                if (fe != null) {
                    fe.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
        }
        try {
            if (fe != null) {
                fe.close();
            }
        }
        catch (IOException e2) {
            System.out.println("Error: " + e2.toString());
        }
    }
    
    public void amosaInicio() {
        FileReader fe = null;
        BufferedReader fbr = null;
        try {
            fe = new FileReader(this.archivo);
            fbr = new BufferedReader(fe);
            String linea;
            while ((linea = fbr.readLine()) != null) {
                System.out.println(String.valueOf(linea.length()) + " --> " + linea);
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.toString());
            try {
                if (fe != null) {
                    fe.close();
                }
                if (fbr != null) {
                    fbr.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
            return;
        }
        finally {
            try {
                if (fe != null) {
                    fe.close();
                }
                if (fbr != null) {
                    fbr.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
        }
        try {
            if (fe != null) {
                fe.close();
            }
            if (fbr != null) {
                fbr.close();
            }
        }
        catch (IOException e2) {
            System.out.println("Error: " + e2.toString());
        }
    }
    
    public void amosaLineaMaior1() {
        FileReader fe = null;
        BufferedReader fbr = null;
        String lineaMaior = null;
        try {
            fe = new FileReader(this.archivo);
            fbr = new BufferedReader(fe);
            int maior = 0;
            String linea;
            while ((linea = fbr.readLine()) != null) {
                final int lonxitude = linea.length();
                if (lonxitude > maior) {
                    maior = lonxitude;
                    lineaMaior = linea;
                }
            }
            System.out.println();
            System.out.println(String.valueOf(lineaMaior.length()) + " --> " + lineaMaior);
        }
        catch (IOException e) {
            System.out.println("Error: " + e.toString());
            try {
                if (fe != null) {
                    fe.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
            return;
        }
        finally {
            try {
                if (fe != null) {
                    fe.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
        }
        try {
            if (fe != null) {
                fe.close();
            }
        }
        catch (IOException e2) {
            System.out.println("Error: " + e2.toString());
        }
    }
    
    public void amosaLineaMaior() {
        FileReader fe = null;
        BufferedReader fbr = null;
        String lineaMaior = null;
        try {
            fe = new FileReader(this.archivo);
            fbr = new BufferedReader(fe);
            int maior = 0;
            if ((lineaMaior = fbr.readLine()) != null) {
                maior = lineaMaior.length();
            }
            String linea;
            while ((linea = fbr.readLine()) != null) {
                final int lonxitude = linea.length();
                if (lonxitude > maior) {
                    maior = lonxitude;
                    lineaMaior = linea;
                }
            }
            System.out.println();
            System.out.println(String.valueOf(lineaMaior.length()) + " --> " + lineaMaior);
        }
        catch (IOException e) {
            System.out.println("Error: " + e.toString());
            try {
                if (fe != null) {
                    fe.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
            return;
        }
        finally {
            try {
                if (fe != null) {
                    fe.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
        }
        try {
            if (fe != null) {
                fe.close();
            }
        }
        catch (IOException e2) {
            System.out.println("Error: " + e2.toString());
        }
    }
    
    public void amosaLineaMaiorMenor() {
        FileReader fe = null;
        BufferedReader fbr = null;
        String linea = null;
        String lineaMaior = null;
        String lineaMenor = null;
        try {
            fe = new FileReader(this.archivo);
            fbr = new BufferedReader(fe);
            int maior = 0;
            int menor = 0;
            if ((linea = fbr.readLine()) != null) {
                maior = linea.length();
                lineaMaior = linea;
                menor = linea.length();
                lineaMenor = linea;
            }
            while ((linea = fbr.readLine()) != null) {
                final int lonxitude = linea.length();
                if (lonxitude > maior) {
                    maior = lonxitude;
                    lineaMaior = linea;
                }
                else {
                    if (lonxitude >= menor) {
                        continue;
                    }
                    menor = lonxitude;
                    lineaMenor = linea;
                }
            }
            System.out.println();
            System.out.println(String.valueOf(lineaMaior.length()) + " --> " + lineaMaior);
            System.out.println(String.valueOf(lineaMenor.length()) + " --> " + lineaMenor);
        }
        catch (IOException e) {
            System.out.println("Error: " + e.toString());
            try {
                if (fe != null) {
                    fe.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
            return;
        }
        finally {
            try {
                if (fe != null) {
                    fe.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
        }
        try {
            if (fe != null) {
                fe.close();
            }
        }
        catch (IOException e2) {
            System.out.println("Error: " + e2.toString());
        }
    }
    
    public void amosaLineaMaiorMenor1() {
        FileReader fe = null;
        BufferedReader fbr = null;
        String linea = null;
        String lineaMaior = null;
        String lineaMenor = null;
        try {
            fe = new FileReader(this.archivo);
            fbr = new BufferedReader(fe);
            int maior = 0;
            int menor = 100;
            while ((linea = fbr.readLine()) != null) {
                final int lonxitude = linea.length();
                if (lonxitude > maior) {
                    maior = lonxitude;
                    lineaMaior = linea;
                }
                else {
                    if (lonxitude >= menor) {
                        continue;
                    }
                    menor = lonxitude;
                    lineaMenor = linea;
                }
            }
            System.out.println();
            System.out.println(String.valueOf(lineaMaior.length()) + " --> " + lineaMaior);
            System.out.println(String.valueOf(lineaMenor.length()) + " --> " + lineaMenor);
        }
        catch (IOException e) {
            System.out.println("Error: " + e.toString());
            try {
                if (fe != null) {
                    fe.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
            return;
        }
        finally {
            try {
                if (fe != null) {
                    fe.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
        }
        try {
            if (fe != null) {
                fe.close();
            }
        }
        catch (IOException e2) {
            System.out.println("Error: " + e2.toString());
        }
    }
    
    public void amosaPalabrasStream() {
        FileReader fe = null;
        StreamTokenizer fst = null;
        try {
            fe = new FileReader(this.archivo);
            fst = new StreamTokenizer(fe);
            fst.whitespaceChars(46, 46);
            while (fst.nextToken() != -1) {
                if (fst.sval != null) {
                    System.out.println(fst.sval);
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.toString());
            try {
                if (fe != null) {
                    fe.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
            return;
        }
        finally {
            try {
                if (fe != null) {
                    fe.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
        }
        try {
            if (fe != null) {
                fe.close();
            }
        }
        catch (IOException e2) {
            System.out.println("Error: " + e2.toString());
        }
    }
    
    public void amosaPalabras() {
        FileReader fe = null;
        BufferedReader fbr = null;
        try {
            fe = new FileReader(this.archivo);
            fbr = new BufferedReader(fe);
            String linea;
            while ((linea = fbr.readLine()) != null) {
                final StringTokenizer st = new StringTokenizer(linea, ".;: ");
                while (st.hasMoreTokens()) {
                    System.out.println(st.nextToken());
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.toString());
            try {
                if (fe != null) {
                    fe.close();
                }
                if (fbr != null) {
                    fbr.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
            return;
        }
        finally {
            try {
                if (fe != null) {
                    fe.close();
                }
                if (fbr != null) {
                    fbr.close();
                }
            }
            catch (IOException e2) {
                System.out.println("Error: " + e2.toString());
            }
        }
        try {
            if (fe != null) {
                fe.close();
            }
            if (fbr != null) {
                fbr.close();
            }
        }
        catch (IOException e2) {
            System.out.println("Error: " + e2.toString());
        }
    }
    
    public static void menu() {
        System.out.println("\n  M E N U");
        System.out.println("  =======");
        System.out.println(" 1.- AMOSA ficheiro");
        System.out.println(" 2.- COPIA ficheiro");
        System.out.println(" 3.- AMOSA ficheiro (lonxitude - FINAL)");
        System.out.println(" 4.- AMOSA ficheiro (lonxitude - INICIO)");
        System.out.println(" 5.- AMOSA ficheiro (a sua linea MAIOR)");
        System.out.println(" 6.- AMOSA ficheiro (a sua linea MAIOR e a MENOR)");
        System.out.println(" 7.- AMOSA ficheiro (por palabras)");
        System.out.println(" 8.- FINAL");
    }
    
    public static int dameOpcion() {
        menu();
        final int opcion = Leer.datoInt();
        return opcion;
    }
}