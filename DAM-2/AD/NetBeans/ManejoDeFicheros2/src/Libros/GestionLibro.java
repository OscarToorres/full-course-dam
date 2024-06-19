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
public class GestionLibro {
    
    public static void main (String [] args){
        
        UtilidadesLibro libro = new UtilidadesLibro();
        ArrayList<Libro> libros = new ArrayList<>();

        libros = libro.generarObjetosLibro();
        libro.generarDatLibro(libros, "libros.dat");
        libro.mostrarLibros("libros.dat");
        libro.XmlLibroDom("libros.dat", "libros.xml");
        libro.generaXmlLibroXStream("libros.dat", "librosXStream.xml");
    }
}
