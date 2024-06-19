// 
// Decompiled by Procyon v0.5.36
// 

package preparatorios.ejem02;

public class CLibreria
{
    private CLibro[] libreria;
    private int total;
    
    public CLibreria() {
        this.libreria = new CLibro[5];
        this.total = 0;
    }
    
    public void llenar() {
        this.libreria[0] = new CLibro(100, "La Celestina", 35.95f);
        this.libreria[1] = new CLibro(200, "El Quijote", 45.75f);
        this.libreria[2] = new CLibro(300, "La Biblia", 38.25f);
        this.libreria[3] = new CLibro(400, "El Barroco", 29.85f);
        this.libreria[4] = new CLibro(500, "La Colmena", 26.15f);
        this.total = 5;
    }
    
    public void vaciar() {
        this.total = 0;
    }
    
    public CLibro dameLibro(final int cod) {
        for (int i = 0; i < this.total; ++i) {
            if (this.libreria[i].getCodigo() == cod) {
                return this.libreria[i];
            }
        }
        return null;
    }
    
    private int dameIndice(final int cod) {
        for (int i = 0; i < this.total; ++i) {
            if (this.libreria[i].getCodigo() == cod) {
                return i;
            }
        }
        return -1;
    }
    
    private void elimina(int i) {
        while (i < this.total - 1) {
            this.libreria[i] = this.libreria[i + 1];
            ++i;
        }
        --this.total;
    }
    
    public void eliminarLibro(final int codigo) {
        final int indice = this.dameIndice(codigo);
        if (indice == -1) {
            System.out.println("Libro no ENCONTRADO");
        }
        else {
            this.elimina(indice);
            System.out.println("Libro ELIMINADO");
        }
    }
    
    public void mostrarLibro(final int cod) {
        final CLibro libro = this.dameLibro(cod);
        if (libro == null) {
            System.out.println("Libro no ENCONTRADO");
        }
        else {
            this.mostrarCabecera();
            libro.mostrar();
        }
    }
    
    public void mostrar() {
        if (this.total == 0) {
            System.out.println("Libreria VACIA");
        }
        else {
            this.mostrarCabecera();
            for (int i = 0; i < this.total; ++i) {
                this.libreria[i].mostrar();
            }
        }
    }
    
    private void mostrarCabecera() {
        System.out.println("CODIGO\tTITULO  \tPRECIO");
        System.out.println("======\t======  \t======");
    }
    
    private void menu() {
        System.out.println("\n  M E N U - 2");
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
