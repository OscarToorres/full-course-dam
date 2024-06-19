// 
// Decompiled by Procyon v0.5.36
// 

package preparatorios.ejem01;

import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;

public class CLibreria
{
    private ArrayList<CLibro> libreria;
    
    public CLibreria() {
        this.libreria = new ArrayList<CLibro>();
    }
    
    public void llenar() {
        this.libreria.removeAll(this.libreria);
        this.libreria.add(new CLibro(100, "La Celestina", 35.95f));
        this.libreria.add(new CLibro(200, "El Quijote", 45.75f));
        this.libreria.add(new CLibro(300, "La Biblia", 38.25f));
        this.libreria.add(new CLibro(400, "El Barroco", 29.85f));
        this.libreria.add(new CLibro(500, "La Colmena", 26.15f));
    }
    
    public void vaciar() {
        this.libreria.removeAll(this.libreria);
    }
    
    private CLibro dameLibro(final int cod) {
        for (final CLibro libro : this.libreria) {
            if (libro.getCodigo() == cod) {
                return libro;
            }
        }
        return null;
    }
    
    public void eliminarLibro(final int codigo) {
        final CLibro libro = this.dameLibro(codigo);
        if (libro == null) {
            System.out.println("libro no ENCONTRADO");
        }
        else {
            this.libreria.remove(libro);
            System.out.println("libro ELIMINADO");
        }
    }
    
    public void mostrarLibro(final int cod) {
        final CLibro libro = this.dameLibro(cod);
        if (libro == null) {
            System.out.println("libro no ENCONTRADO");
        }
        else {
            this.mostrarCabecera();
            libro.mostrar();
        }
    }
    
    private void mostrarDato(final Iterator<CLibro> iterator) {
        if (iterator.hasNext()) {
            final CLibro libro = iterator.next();
            this.mostrarDato(iterator);
            libro.mostrar();
        }
    }
    
    public void mostrar() {
        final Iterator<CLibro> iterator = this.libreria.iterator();
        if (this.libreria.isEmpty()) {
            System.out.println("libreria VACIA");
        }
        else {
            this.mostrarCabecera();
            this.mostrarDato(iterator);
        }
    }
    
    private void mostrarCabecera() {
        System.out.println("CODIGO\tTITULO  \tPRECIO");
        System.out.println("======\t======  \t======");
    }
    
    private void menu() {
        System.out.println("\n  M E N U - 1");
        System.out.println("  ===========");
        System.out.println("1.- LLENAR libreria");
        System.out.println("2.- VACIAR libreria");
        System.out.println("3.- MOSTRAR libreria");
        System.out.println("4.- MOSTRAR libro");
        System.out.println("5.- ELIMINAR libro");
        System.out.println("6.- FINAL");
        System.out.print("Pulsa opci\u00f3n: ");
    }
    
    public int dameOpcion() {
        this.menu();
        final int opcion = Leer.datoInt();
        System.out.println();
        return opcion;
    }
}
