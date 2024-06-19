package ejemplogson;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author fprimag
 */
public class UtilidadesGson {
    
    public void write(List<Alumno> alumno, String ruta) {
        // Crear objeto Gson
        Gson gson = new Gson();
        // Convertir objeto Java Alumno a String JSON usando Gson
        String jsonAlumno = gson.toJson(alumno);

        //Guardar String JSON en el fichero
        try (FileWriter fichero = new FileWriter(ruta)){
//            FileWriter fichero = new FileWriter(ruta);
            fichero.write(jsonAlumno);
            fichero.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
    public Alumno read(String ruta) {
        // Crear objetos Gson y Alumno
        Gson gson = new Gson();
        Alumno alumno = new Alumno();
        
        //Leer del fichero y convertir a objeto Java Alumno usando Gson
        try {
            FileReader fichero = new FileReader(ruta);
            alumno = gson.fromJson(fichero, Alumno.class);
            fichero.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        
        return alumno;
    }
}
