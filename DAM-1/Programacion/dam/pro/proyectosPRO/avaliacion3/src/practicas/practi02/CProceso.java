package practicas.practi02;

public class CProceso
{
    private String identificador;
    private String titulo;
    private float arancel;
    
    public CProceso(final String ide, final String tit, final float ara) {
        this.identificador = ide;
        this.titulo = tit;
        this.arancel = ara;
    }
    
    public String getIdentificador() {
        return this.identificador;
    }
    
    public void setIdentificador(final String ide) {
        this.identificador = ide;
    }
    
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(final String tit) {
        this.titulo = tit;
    }
    
    public float getArancel() {
        return this.arancel;
    }
    
    public void setArancel(final float ara) {
        this.arancel = ara;
    }
    
    public void mostrar() {
        System.out.println(String.valueOf(this.identificador) + "\t\t" + this.titulo + "\t" + this.arancel);
    }
}