// 
// Decompiled by Procyon v0.5.36
// 

package misClases.teoria;

public class CPersona1
{
    private String nombre;
    private String direccion;
    private long telefono;
    
    public CPersona1() {
    }
    
    public CPersona1(final String nom, final String dir, final long tel) {
        this.nombre = nom;
        this.direccion = dir;
        this.telefono = tel;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(final String direccion) {
        this.direccion = direccion;
    }
    
    public long getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(final long telefono) {
        this.telefono = telefono;
    }
    
    public void mostrarPersona() {
        System.out.println(this.nombre);
        System.out.println(this.direccion);
        System.out.println(this.telefono);
        System.out.println();
    }
}
