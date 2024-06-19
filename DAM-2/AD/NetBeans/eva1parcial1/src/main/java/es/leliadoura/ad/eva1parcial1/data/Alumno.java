package es.leliadoura.ad.eva1parcial1.data;

/**
 *
 * @author marco
 */
public class Alumno {
    private String nombre;
    private String dni;

    public Alumno() {
    }

    public Alumno(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", dni=" + dni + '}';
    }


    
}
