// 
// Decompiled by Procyon v0.5.36
// 

package preparatorios.prepara05;

import preparatorios.ejem05.Leer;
import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;

public class CFruteria
{
    private RandomAccessFile fes;
    private int nregs;
    private int tamanhoReg;
    private File fichero;
    
    public CFruteria(final File fich) throws IOException {
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
    
    public void insertar(final int i, final CFruta fruta) throws IOException {
        this.fes.seek(i * this.tamanhoReg);
        this.fes.writeUTF(fruta.getCodigo());
        this.fes.writeUTF(fruta.getNombre());
        this.fes.writeInt(fruta.getCantidad());
        this.fes.writeFloat(fruta.getPrecio());
    }
    
    public void llenar() throws IOException {
        this.vaciar();
        this.insertar(0, new CFruta("F01", "Aguacates", 52, 3.25f));
        this.insertar(1, new CFruta("F02", "Zanahorias", 34, 5.45f));
        this.insertar(2, new CFruta("F03", "Platanos", 57, 4.75f));
        this.insertar(3, new CFruta("F04", "Manzanas", 47, 2.85f));
        this.insertar(4, new CFruta("F05", "Mandarinas", 61, 3.55f));
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
    
    private CFruta dameDatosFruta() {
        System.out.print("Dame codigo: ");
        final String codigo = Leer.datoString();
        System.out.print("Dame nombre: ");
        final String nombre = Leer.datoString();
        System.out.print("Dame cantidad: ");
        final int cantidad = Leer.datoInt();
        System.out.print("Dame precio: ");
        final float precio = Leer.datoFloat();
        return new CFruta(codigo, nombre, cantidad, precio);
    }
    
    private CFruta dameFruta(final int pos) throws IOException {
        if (pos >= 0 && pos < this.nregs) {
            this.fes.seek(pos * this.tamanhoReg);
            final String codigo = this.fes.readUTF();
            final String nombre = this.fes.readUTF();
            final int cantidad = this.fes.readInt();
            final float precio = this.fes.readFloat();
            return new CFruta(codigo, nombre, cantidad, precio);
        }
        return null;
    }
    
    private int damePosicion(final String cod) throws IOException {
        for (int i = 0; i < this.nregs; ++i) {
            this.fes.seek(i * this.tamanhoReg);
            final String codigo = this.fes.readUTF();
            if (codigo.equals(cod)) {
                return i;
            }
        }
        return -1;
    }
    
    public void eliminarFruta(final String cod) throws IOException {
        final int posicion = this.damePosicion(cod);
        final CFruta fruta = this.dameFruta(posicion);
        if (fruta == null) {
            System.out.println("Fruta no ENCONTRADA");
        }
        else {
            fruta.setCantidad(-1);
            this.insertar(posicion, fruta);
            System.out.println("Fruta ELIMINADA");
        }
    }
    
    public void insertarFruta() throws IOException {
        final CFruta fruta = this.dameDatosFruta();
        this.insertar(this.nregs, fruta);
        ++this.nregs;
    }
    
    public void modificarFruta(final String cod) throws IOException {
        final int posicion = this.damePosicion(cod);
        CFruta fruta = this.dameFruta(posicion);
        if (fruta == null) {
            System.out.println("fruta no ENCONTRADA");
        }
        else {
            this.mostrarCabecera();
            fruta.mostrar();
            fruta = this.dameDatosFruta();
            this.insertar(posicion, fruta);
            System.out.println("fruta MODIFICADA");
        }
    }
    
    public void actualizar() throws IOException {
        if (this.nregs == 0) {
            System.out.println("Fruter\u00eda VACIA");
            return;
        }
        final File ficheroTemp = new File("ejem05.tmp");
        final CFruteria fruteriaTemporal = new CFruteria(ficheroTemp);
        int pos = 0;
        int i = 0;
        while (pos < this.nregs) {
            final CFruta fruta = this.dameFruta(pos);
            if (fruta.getCantidad() != -1) {
                fruteriaTemporal.insertar(i, fruta);
                ++i;
            }
            ++pos;
        }
        fruteriaTemporal.cerrar();
        this.cerrar();
        this.fichero.delete();
        if (!ficheroTemp.renameTo(this.fichero)) {
            throw new IOException("NO se renombro el fichero: " + ficheroTemp.getName());
        }
        this.fes = new RandomAccessFile(this.fichero, "rw");
        this.nregs = i;
    }
    
    public void mostrarFruta(final String cod) throws IOException {
        final int pos = this.damePosicion(cod);
        final CFruta fruta = this.dameFruta(pos);
        if (fruta == null) {
            System.out.println("Fruta no ENCONTRADA");
        }
        else {
            this.mostrarCabecera();
            fruta.mostrar();
        }
    }
    
    public void mostrar() throws IOException {
        if (this.nregs == 0) {
            System.out.println("Fruter\u00eda VACIA");
            return;
        }
        this.mostrarCabecera();
        for (int pos = 0; pos < this.nregs; ++pos) {
            final CFruta fruta = this.dameFruta(pos);
            fruta.mostrar();
        }
    }
    
    private void mostrarCabecera() {
        System.out.println("CODIGO\t\tNOMBRE  \tCANTIDAD\tPRECIO");
        System.out.println("======\t\t======  \t========\t======");
    }
    
    private void menu() {
        System.out.println("\n  M E N U - 5");
        System.out.println("  ===========");
        System.out.println("1.- LLENAR fruteria");
        System.out.println("2.- VACIAR fruteria");
        System.out.println("3.- MOSTRAR fruteria");
        System.out.println("4.- MOSTRAR fruta");
        System.out.println("5.- INSERTAR fruta");
        System.out.println("6.- MODIFICAR fruta");
        System.out.println("7.- ELIMINAR fruta");
        System.out.println("8.- ACTUALIZAR fruteria");
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
