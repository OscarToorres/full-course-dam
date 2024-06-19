package es.leliadoura.ad.eva1parcial1.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class Ciclo {
    
    private String nombre;
    private Direccion direccion;
    private List<Modulo> modulos;

    public Ciclo() {
        this.modulos = new ArrayList<>();
    }

    public Ciclo(String nombre, Direccion direccion, List<Modulo> modulos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.modulos = modulos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    @Override
    public String toString() {
        return "Ciclo{" + "nombre=" + nombre + ", direccion=" + direccion + ", modulos=" + modulos + '}';
    }
}
