// 
// Decompiled by Procyon v0.5.36
// 

package preparatorios.prepara03;

public class CFruta
{
    private String codigo;
    private String nombre;
    private int cantidad;
    private float precio;
    
    public CFruta(final String cod, final String nom, final int can, final float pre) {
        this.codigo = cod;
        this.nombre = nom;
        this.cantidad = can;
        this.precio = pre;
    }
    
    public void setCodigo(final String cod) {
        this.codigo = cod;
    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setNombre(final String nom) {
        this.nombre = nom;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setCantidad(final int can) {
        this.cantidad = can;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setPrecio(final float pre) {
        this.precio = pre;
    }
    
    public float getPrecio() {
        return this.precio;
    }
    
    public void mostrar() {
        System.out.print(String.valueOf(this.codigo) + "\t\t" + this.nombre + "\t");
        System.out.println(String.valueOf(this.cantidad) + "\t\t" + this.precio);
    }
}
