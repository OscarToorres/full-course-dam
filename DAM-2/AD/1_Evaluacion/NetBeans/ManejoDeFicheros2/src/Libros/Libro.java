package Libros;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author dam220
 */
public class Libro implements Serializable{
    
    private String isbn;
    private String titulo;
    private ArrayList<String> autores;
    private Integer ano;
    private boolean prestado;
    private Persona lector;

    public Libro(String isbn, String titulo, ArrayList<String> autores, Integer ano, boolean prestado, Persona lector) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autores = autores;
        this.ano = ano;
        this.prestado = prestado;
        this.lector = lector;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public Persona getLector() {
        return lector;
    }

    public void setLector(Persona lector) {
        this.lector = lector;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + ", autores=" + autores + ", ano=" + ano + ", prestado=" + prestado + ", lector=" + lector + '}';
    }

}
