package biblioteca;

public interface Prestamos {
        
    public void prestar(int codigo);
    public void devolver(int codigo);
    public void usar(int codigo);
    public void consultar(int codigo);
    public void addEjemplar(Ejemplar ejemplar);
    public Ejemplar buscarEjemplar(int codigo);
    public void borrarEjemplar();
    public void mostrarLista();    
}
