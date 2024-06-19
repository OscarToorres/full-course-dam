package biblioteca;

import java.util.Date;

public class Libros extends Ejemplar {
    
    private String autor;
    private String resumen;
    private String isbn;

    public Libros(String autor, String resumen, String isbn, String titulo, int codigo, Estado estado) {
        super(titulo, codigo, estado);
        this.autor = autor;
        this.resumen = resumen;
        this.isbn = isbn; 
    }

    public Libros(String autor, String resumen, String isbn, String titulo, int codigo, Estado estado, Usuario usuario, Date fecPrestamo, Date fecDevolucion) {
        super(titulo, codigo, estado, usuario, fecPrestamo, fecDevolucion);
        this.autor = autor;
        this.resumen = resumen;
        this.isbn = isbn;
    }
  
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libros{" + super.toString()+ ", autor=" + autor + ", resumen=" + resumen + ", isbn=" + isbn + '}';
    }
    
    
    
    
}
