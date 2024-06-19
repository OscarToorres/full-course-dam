package es.leliadoura.ad.eva1parcial1.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Clase de generación de datos para pruebas
 * @author marco
 */
public class GeneradorDatos {
    
    /**
     * Genera un listado de alumnos aleatorio con sus datos
     * @return la lista de alumnos
     */
    public List<Alumno> creaAlumnos() {
        List<Alumno> lista = new ArrayList<>();
        
        lista.add(new Alumno("Pepe", "1A"));
        lista.add(new Alumno("Juan", "2B"));
        lista.add(new Alumno("Laura", "3C"));
        lista.add(new Alumno("Sofia", "4D"));
        lista.add(new Alumno("Maria", "5E"));
        lista.add(new Alumno("Jose", "6F"));
        lista.add(new Alumno("Marcelo", "7G"));
        lista.add(new Alumno("Inés", "8H"));
        lista.add(new Alumno("Rodrigo", "9I"));
        lista.add(new Alumno("Carlos", "10J"));
        lista.add(new Alumno("Carmen", "11K"));
        
        Collections.shuffle(lista);
        
        return new ArrayList(lista.subList(0, new Random().nextInt(6)+1));
    }
    
    /**
     * Genera una lista aleatoria de unidades con sus datos
     * @return la lista de alumnos
     */
    public List<Unidad> creaUnidades() {
        List<Unidad> lista = new ArrayList<>();
        
        lista.add(new Unidad("Unidad 1", "Ficheros"));
        lista.add(new Unidad("Unidad 2", "Conectores"));
        lista.add(new Unidad("Unidad 3", "Mapeo"));
        lista.add(new Unidad("Unidad 4", "Objetos"));
        lista.add(new Unidad("Unidad 5", "Seguridad"));
        lista.add(new Unidad("Unidad 6", "XML"));
        lista.add(new Unidad("Unidad 7", "Concurrencia"));
        lista.add(new Unidad("Unidad 8", "Hilos"));
        lista.add(new Unidad("Unidad 9", "Swing"));
        lista.add(new Unidad("Unidad 10", "Spring"));
        lista.add(new Unidad("Unidad 11", "FX"));
        
        Collections.shuffle(lista);
        
        return new ArrayList(lista.subList(0, new Random().nextInt(4)+1));
    }
    
    /**
     * Genera una lista aleatoria de módulos con todos sus datos
     * @return la lista de módulos
     */
    public List<Modulo> creaModulos() {
        List<Modulo> lista = new ArrayList<>();
        
        lista.add(new Modulo(2, "Acceso a Datos", creaAlumnos(), creaUnidades()));
        lista.add(new Modulo(1, "Bases de datos", creaAlumnos(), creaUnidades()));
        lista.add(new Modulo(1, "Programación", creaAlumnos(), creaUnidades()));
        lista.add(new Modulo(1, "Lenguajes", creaAlumnos(), creaUnidades()));
        lista.add(new Modulo(2, "Intefaces", creaAlumnos(), creaUnidades()));
        lista.add(new Modulo(2, "Móviles", creaAlumnos(), creaUnidades()));
        lista.add(new Modulo(2, "Proyecto", creaAlumnos(), creaUnidades()));
        lista.add(new Modulo(2, "FCT", creaAlumnos(), creaUnidades()));
        
        Collections.shuffle(lista);
        
        return new ArrayList(lista.subList(0, new Random().nextInt(5)+1));
    }
    
    /**
     * Genera una lista de direcciones de forma aleatoria con todos sus datos
     * @return la lista de direcciones
     */
    public List<Direccion> creaDirecciones() {
        List<Direccion> lista = new ArrayList<>();
        
        lista.add(new Direccion("Lisboa", "Santiago", 2, 15703));
        lista.add(new Direccion("Londres", "Santiago", 2, 15703));
        lista.add(new Direccion("Rio", "Santiago", 2, 15702));
        lista.add(new Direccion("Madrid", "Santiago", 2, 15702));
        lista.add(new Direccion("Munich", "Santiago", 2, 15701));
        lista.add(new Direccion("Paris", "Santiago", 2, 15701));
        lista.add(new Direccion("Vilagarcía", "Santiago", 2, 15706));
        
        Collections.shuffle(lista);
        
        return new ArrayList(lista.subList(0, new Random().nextInt(4)+1));
    }
    
    /**
     * Genera un listado aleatorio de ciclos con todos sus datos
     * @return la lista de ciclos
     */
    public List<Ciclo> creaCiclos() {
        List<Ciclo> lista = new ArrayList<>();
        
        lista.add(new Ciclo("DAM", creaDirecciones().get(0), creaModulos()));
        lista.add(new Ciclo("DAW", creaDirecciones().get(0), creaModulos()));
        lista.add(new Ciclo("ASIR", creaDirecciones().get(0), creaModulos()));
        
        Collections.shuffle(lista);
        
        return lista;
    }
}
