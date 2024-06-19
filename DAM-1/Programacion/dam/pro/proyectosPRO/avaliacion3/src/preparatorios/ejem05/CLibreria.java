package preparatorios.ejem05;

import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;

public class CLibreria
{
    private RandomAccessFile fes;
    private int nregs;
    private int tamanhoReg;
    private File fichero;
    
    public CLibreria(final File fich) throws IOException {
        this.fichero = fich;
        if (this.fichero.exists() && !this.fichero.isFile()) {
            throw new IOException(String.valueOf(this.fichero.getName()) + " es un DIRECTORIO");
        }
        this.fes = new RandomAccessFile(this.fichero, "rw");
        this.tamanhoReg = 100;
        this.nregs = (int)Math.ceil(this.fes.length() / (double)this.tamanhoReg);
    }
    
    public void cerrar() throws IOException {
        this.fes.close();
    }
    
    public void insertar(final int i, final CLibro libro) throws IOException {
        this.fes.seek(i * this.tamanhoReg);
        this.fes.writeInt(libro.getCodigo());
        this.fes.writeUTF(libro.getTitulo());
        this.fes.writeFloat(libro.getPrecio());
    }
    
    public void llenar() throws IOException {
        this.vaciar();
        this.insertar(0, new CLibro(100, "La Celestina", 35.95f));
        this.insertar(1, new CLibro(200, "El Quijote", 45.75f));
        this.insertar(2, new CLibro(300, "La Biblia", 38.25f));
        this.insertar(3, new CLibro(400, "El Barroco", 29.85f));
        this.insertar(4, new CLibro(500, "La Colmena", 26.15f));
        this.nregs = 5;
    }
    
    public void vaciar() throws IOException {
        this.fes.close();
        if (!this.fichero.delete()) {
            throw new IOException("No se borr\u00f3 el fichero: " + this.fichero.getName());
        }
        this.fes = new RandomAccessFile(this.fichero, "rw");
        this.nregs = 0;
    }
    
    private CLibro dameDatosLibro() {
        System.out.print("Dame codigo: ");
        final int codigo = Leer.datoInt();
        System.out.print("Dame t\u00edtulo: ");
        final String titulo = Leer.datoString();
        System.out.print("Dame precio: ");
        final float precio = Leer.datoFloat();
        return new CLibro(codigo, titulo, precio);
    }
    
    private CLibro dameLibro(final int pos) throws IOException {
        if (pos >= 0 && pos < this.nregs) {
            this.fes.seek(pos * this.tamanhoReg);
            final int codigo = this.fes.readInt();
            final String titulo = this.fes.readUTF();
            final float precio = this.fes.readFloat();
            return new CLibro(codigo, titulo, precio);
        }
        return null;
    }
    
    private int damePosicion(final int cod) throws IOException {
        for (int i = 0; i < this.nregs; ++i) {
            this.fes.seek(i * this.tamanhoReg);
            final int codigo = this.fes.readInt();
            if (codigo == cod) {
                return i;
            }
        }
        return -1;
    }
    
    public void mostrar() throws IOException {
        if (this.nregs == 0) {
            System.out.println("Libreria VACIA");
            return;
        }
        this.mostrarCabecera();
        for (int pos = 0; pos < this.nregs; ++pos) {
            final CLibro libro = this.dameLibro(pos);
            libro.mostrar();
        }
    }
    
    private void mostrarCabecera() {
        System.out.println("CODIGO\tTITULO  \tPRECIO");
        System.out.println("======\t======  \t======");
    }
    
    public void mostrarLibro(final int cod) throws IOException {
        final int pos = this.damePosicion(cod);
        final CLibro libro = this.dameLibro(pos);
        if (libro == null) {
            System.out.println("libro no ENCONTRADO");
        }
        else {
            this.mostrarCabecera();
            libro.mostrar();
        }
    }
    
    public void insertarLibro() throws IOException {
        final CLibro libro = this.dameDatosLibro();
        this.insertar(this.nregs, libro);
        ++this.nregs;
    }
    
    public void modificarLibro(final int cod) throws IOException {
        final int posicion = this.damePosicion(cod);
        CLibro libro = this.dameLibro(posicion);
        if (libro == null) {
            System.out.println("libro no ENCONTRADO");
        }
        else {
            this.mostrarCabecera();
            libro.mostrar();
            libro = this.dameDatosLibro();
            this.insertar(posicion, libro);
            System.out.println("libro MODIFICADO");
        }
    }
    
    public void eliminarLibro(final int cod) throws IOException {
        final int posicion = this.damePosicion(cod);
        final CLibro libro = this.dameLibro(posicion);
        if (libro == null) {
            System.out.println("libro no ENCONTRADO");
        }
        else {
            libro.setPrecio(0.0f);
            this.insertar(posicion, libro);
            System.out.println("libro ELIMINADO");
        }
    }
    
    public void actualizar() throws IOException {
        if (this.nregs == 0) {
            System.out.println("Libreria VACIA");
            return;
        }
        final File ficheroTemp = new File("ejem05.tmp");
        final CLibreria libreriaTemporal = new CLibreria(ficheroTemp);
        int pos = 0;
        int i = 0;
        while (pos < this.nregs) {
            final CLibro libro = this.dameLibro(pos);
            if (libro.getPrecio() != 0.0f) {
                libreriaTemporal.insertar(i, libro);
                ++i;
            }
            ++pos;
        }
        libreriaTemporal.cerrar();
        this.cerrar();
        this.fichero.delete();
        if (!ficheroTemp.renameTo(this.fichero)) {
            throw new IOException("NO se renombro el fichero: " + ficheroTemp.getName());
        }
        this.fes = new RandomAccessFile(this.fichero, "rw");
        this.nregs = i;
    }
    
    private void menu() {
        System.out.println("\n  M E N U - 5");
        System.out.println("  ===========");
        System.out.println("1.- LLENAR libreria");
        System.out.println("2.- VACIAR libreria");
        System.out.println("3.- MOSTRAR libreria");
        System.out.println("4.- MOSTRAR libro");
        System.out.println("5.- INSERTAR libro");
        System.out.println("6.- MODIFICAR libro");
        System.out.println("7.- ELIMINAR libro");
        System.out.println("8.- ACTUALIZAR libreria");
        System.out.println("9.- FINAL");
        System.out.print("Pulsa opci\u00f3n: ");
    }
    
    public int dameOpcion() {
        this.menu();
        final int opcion = Leer.datoInt();
        System.out.println();
        return opcion;
    }
}
