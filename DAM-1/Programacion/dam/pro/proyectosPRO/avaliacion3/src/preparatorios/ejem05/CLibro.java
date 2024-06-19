package preparatorios.ejem05;

public class CLibro
{
    private int codigo;
    private String titulo;
    private float precio;
    
    public CLibro(final int cod, final String tit, final float pre) {
        this.codigo = cod;
        this.titulo = tit;
        this.precio = pre;
    }
    
    public void setCodigo(final int cod) {
        this.codigo = cod;
    }
    
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setTitulo(final String tit) {
        this.titulo = tit;
    }
    
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setPrecio(final float pre) {
        this.precio = pre;
    }
    
    public float getPrecio() {
        return this.precio;
    }
    
    public void mostrar() {
        System.out.println(String.valueOf(this.codigo) + "\t" + this.titulo + "\t" + this.precio);
    }
}
