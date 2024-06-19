// 
// Decompiled by Procyon v0.5.36
// 

package misClases.teoria;

import misClases.utilidades.CDatos;
import java.io.Serializable;

public class CPersona implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String direccion;
    private long telefono;
    
    public CPersona() {
    }
    
    public CPersona(final String nom, final String dir, final long tel) {
        this.nombre = nom;
        this.direccion = dir;
        this.telefono = tel;
    }
    
    public void asignarNombre(final String nom) {
        this.nombre = nom;
    }
    
    public String obtenerNombre() {
        return this.nombre;
    }
    
    public void asignarDireccion(final String dir) {
        this.direccion = dir;
    }
    
    public String obtenerDireccion() {
        return this.direccion;
    }
    
    public void asignarTelefono(final long tel) {
        this.telefono = tel;
    }
    
    public long obtenerTelefono() {
        return this.telefono;
    }
    
    public int tamanho() {
        return this.nombre.length() * 2 + this.direccion.length() * 2 + 8;
    }
    
    public void mostrar() {
        System.out.println(this.nombre);
        System.out.println(this.direccion);
        System.out.println(this.telefono);
        System.out.println();
    }
    
    public void asignarDatos() {
        this.nombre = CDatos.obtenerNombreCompleto();
        this.direccion = CDatos.obtenerDireccion();
        this.telefono = CDatos.obtenerTelefono();
    }
}
