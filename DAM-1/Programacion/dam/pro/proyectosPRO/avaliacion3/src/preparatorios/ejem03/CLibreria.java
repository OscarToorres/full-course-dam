package preparatorios.ejem03;

import java.io.EOFException;
import java.io.FileInputStream;
import java.util.Iterator;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

public class CLibreria
{
    private ArrayList<CLibro> libreria;
    private DataOutputStream flujoSalida;
    private DataInputStream flujoEntrada;
    private File fichero;
    
    public CLibreria(final File fich) {
        this.libreria = new ArrayList<CLibro>();
        this.fichero = fich;
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
    
    public void salvar() {
        final Iterator<CLibro> iterator = this.libreria.iterator();
        this.flujoSalida = null;
        try {
            this.flujoSalida = new DataOutputStream(new FileOutputStream(this.fichero));
            while (iterator.hasNext()) {
                final CLibro libro = iterator.next();
                this.flujoSalida.writeInt(libro.getCodigo());
                this.flujoSalida.writeUTF(libro.getTitulo());
                this.flujoSalida.writeFloat(libro.getPrecio());
            }
        }
        catch (IOException e) {
            System.out.println("problemas al SALVAR el fichero");
            if (this.flujoSalida != null) {
                try {
                    this.flujoSalida.close();
                }
                catch (IOException e2) {
                    System.out.println("problemas al CERRAR el flujo de salida");
                }
            }
            return;
        }
        finally {
            if (this.flujoSalida != null) {
                try {
                    this.flujoSalida.close();
                }
                catch (IOException e2) {
                    System.out.println("problemas al CERRAR el flujo de salida");
                }
            }
        }
        if (this.flujoSalida != null) {
            try {
                this.flujoSalida.close();
            }
            catch (IOException e2) {
                System.out.println("problemas al CERRAR el flujo de salida");
            }
        }
    }
    
    public void restaurar() {
        this.flujoEntrada = null;
        try {
            this.flujoEntrada = new DataInputStream(new FileInputStream(this.fichero));
            this.libreria.removeAll(this.libreria);
            while (true) {
                final int codigo = this.flujoEntrada.readInt();
                final String titulo = this.flujoEntrada.readUTF();
                final float precio = this.flujoEntrada.readFloat();
                this.libreria.add(new CLibro(codigo, titulo, precio));
            }
        }
        catch (EOFException ex) {}
        catch (IOException e) {
            System.out.println("problemas al RESTAURAR el fichero");
        }
        finally {
            if (this.flujoEntrada != null) {
                try {
                    this.flujoEntrada.close();
                }
                catch (IOException e2) {
                    System.out.println("problemas al CERRAR el flujo de entrada");
                }
            }
        }
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
    
    public void insertarLibro() {
        System.out.print("Dame codigo: ");
        final int codigo = Leer.datoInt();
        System.out.print("Dame t\u00edtulo: ");
        final String titulo = Leer.datoString();
        System.out.print("Dame precio: ");
        final float precio = Leer.datoFloat();
        this.libreria.add(new CLibro(codigo, titulo, precio));
    }
    
    public void modificarLibro(final int codigo) {
        final CLibro libro = this.dameLibro(codigo);
        if (libro == null) {
            System.out.println("libro no ENCONTRADO");
        }
        else {
            System.out.println("Precio ACTUAL: " + libro.getPrecio());
            System.out.print("Dame precio NUEVO: ");
            final float precio = Leer.datoFloat();
            libro.setPrecio(precio);
            System.out.println("libro MODIFICADO");
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
    
    public void mostrar() {
        final Iterator<CLibro> iterator = this.libreria.iterator();
        if (this.libreria.isEmpty()) {
            System.out.println("libreria VACIA");
        }
        else {
            this.mostrarCabecera();
            while (iterator.hasNext()) {
                iterator.next().mostrar();
            }
        }
    }
    
    private void mostrarCabecera() {
        System.out.println("CODIGO\tTITULO  \tPRECIO");
        System.out.println("======\t======  \t======");
    }
    
    private void menu() {
        System.out.println("\n  M E N U - 3");
        System.out.println("  ===========");
        System.out.println("1.- LLENAR libreria");
        System.out.println("2.- VACIAR libreria");
        System.out.println("3.- MOSTRAR libreria");
        System.out.println("4.- MOSTRAR libro");
        System.out.println("5.- INSERTAR libro");
        System.out.println("6.- MODIFICAR libro");
        System.out.println("7.- ELIMINAR libro");
        System.out.println("8.- SALVAR en fichero");
        System.out.println("9.- RESTAURAR de fichero");
        System.out.println("10.- FINAL");
        System.out.print("Pulsa opci\u00f3n: ");
    }
    
    public int dameOpcion() {
        this.menu();
        final int opcion = Leer.datoInt();
        System.out.println();
        return opcion;
    }
}
