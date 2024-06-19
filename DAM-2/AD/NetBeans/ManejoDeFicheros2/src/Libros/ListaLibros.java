/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libros;

import java.util.ArrayList;

/**
 *
 * @author solda
 */
public class ListaLibros {
    
    private ArrayList<Libro> libros = new ArrayList<>();

    public ListaLibros() {
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "ListaLibros{" + "libros=" + libros + '}';
    }
}
