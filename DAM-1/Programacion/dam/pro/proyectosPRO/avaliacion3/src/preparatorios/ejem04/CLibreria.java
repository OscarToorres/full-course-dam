package preparatorios.ejem04;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CLibreria
{
    private CLibro[] libreria;
    private int total;
    private ObjectOutputStream flujoSalida;
    private ObjectInputStream flujoEntrada;
    private File fichero;
    
    public CLibreria(final File fich) {
        this.libreria = new CLibro[10];
        this.total = 0;
        this.fichero = fich;
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
    
    public void salvar() {
        if (this.total == 0) {
            System.out.println("libreria VACIA");
        }
        else {
            this.flujoSalida = null;
            try {
                this.flujoSalida = new ObjectOutputStream(new FileOutputStream(this.fichero));
                for (int i = 0; i < this.total; ++i) {
                    this.flujoSalida.writeObject(this.libreria[i]);
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
    }
    
    public void restaurar() {
        this.flujoEntrada = null;
        int i = 0;
        try {
            this.flujoEntrada = new ObjectInputStream(new FileInputStream(this.fichero));
            while (true) {
                this.libreria[i] = (CLibro)this.flujoEntrada.readObject();
                ++i;
            }
        }
        catch (ClassNotFoundException e) {
            System.out.println("problemas con la clase CLibro");
        }
        catch (EOFException ex) {}
        catch (IOException e2) {
            System.out.println("problemas al RESTAURAR el fichero");
        }
        finally {
            if (this.flujoEntrada != null) {
                try {
                    this.flujoEntrada.close();
                }
                catch (IOException e3) {
                    System.out.println("problemas al CERRAR el flujo de entrada");
                }
            }
        }
        this.total = i;
    }
    
    private CLibro dameLibro(final int cod) {
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
            System.out.println("libro no ENCONTRADO");
        }
        else {
            this.elimina(indice);
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
        this.libreria[this.total] = new CLibro(codigo, titulo, precio);
        ++this.total;
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
        if (this.total == 0) {
            System.out.println("libreria VACIA");
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
        System.out.println("\n  M E N U - 4");
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
