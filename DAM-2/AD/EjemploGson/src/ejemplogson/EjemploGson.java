package ejemplogson;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author fprimag
 */
public class EjemploGson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear alumno(s) y modulo(s) con datos de prueba
        List<Alumno> alumnos = new ArrayList<>();
        Alumno alumno1 = new Alumno();
        alumno1.setNombre("Pedro");
        alumno1.setApellidos("Pérez López");
        alumno1.setDni("1A");
        alumno1.setNacimiento(new GregorianCalendar(1998, Calendar.FEBRUARY, 28).getTime());

        Alumno alumno2 = new Alumno();
        alumno2.setNombre("Luis");
        alumno2.setApellidos("Lustres López");
        alumno2.setDni("2A");
        alumno2.setNacimiento(new GregorianCalendar(1998, Calendar.FEBRUARY, 28).getTime());

        Modulo ad = new Modulo("AD", "MP01010");
        Modulo di = new Modulo("DI", "MP12121");
        alumno1.getModulos().add(ad);
        alumno1.getModulos().add(di);
        alumno2.getModulos().add(ad);
        alumno2.getModulos().add(di);

        alumnos.add(alumno1);
        alumnos.add(alumno2);
        
        System.out.println(alumnos);
        
        // (Opcional) Visualizar alumno para ver si está bien
        System.out.println(alumno1.toString());

        // Crear objeto Gson
        Gson gson = new Gson();

        // Convertir objeto Java Alumno a String JSON usando Gson
        String jsonAlumno = gson.toJson(alumnos);
        // (Opcional) Visualizar jsonAlumno para ver si está bien
        System.out.println(jsonAlumno);

        // Convertir String JSON a objeto Java Alumno usando Gson
//        Alumno alumnoRecuperado = gson.fromJson(jsonAlumno, Alumno.class);
        // (Opcional) Visualizar alumnoRecuperado para ver si está bien
//        System.out.println(alumnoRecuperado);

        // Crear objeto Java UtilidadesGson para escribir y leer
        UtilidadesGson json = new UtilidadesGson();

        // Escribir archivo JSON usando método write de UtilidadesGson
        json.write(alumnos, "alumno.json");

        // Leer archivo JSON usando método read de UtilidadesGson
        Alumno alumnoLeido = json.read("alumno.json");
        System.out.println(alumnoLeido);
    }

}
