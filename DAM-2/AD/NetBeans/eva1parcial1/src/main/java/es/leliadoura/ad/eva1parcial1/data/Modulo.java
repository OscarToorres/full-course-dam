package es.leliadoura.ad.eva1parcial1.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class Modulo {
    private long curso;
    private String descripcion;
    private List<Alumno> alumnos;
    private List<Unidad> unidades;

    public Modulo() {
        this.alumnos = new ArrayList<>();
        this.unidades = new ArrayList<>();
    }

    public Modulo(long curso, String descripcion, List<Alumno> alumnos, List<Unidad> unidades) {
        this.curso = curso;
        this.descripcion = descripcion;
        this.alumnos = alumnos;
        this.unidades = unidades;
    }

    public long getCurso() {
        return curso;
    }

    public void setCurso(long curso) {
        this.curso = curso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Unidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidad> unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Modulo{" + "curso=" + curso + ", descripcion=" + descripcion + ", alumnos=" + alumnos + ", unidades=" + unidades + '}';
    }


    
}
