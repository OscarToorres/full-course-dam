package ejemplogson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fprimag
 */
public class Alumno {
    private String dni;
    private String nombre;
    private String apellidos;
    private Date nacimiento;
    private List<Modulo> modulos;

    public Alumno() {
        this.modulos = new ArrayList<>();
    }

    public Alumno(String dni, String nombre, String apellidos, Date nacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.modulos = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    @Override
    public String toString() {
        return "Alumno{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nacimiento=" + nacimiento + ", modulos=" + modulos + '}';
    }
    
}
