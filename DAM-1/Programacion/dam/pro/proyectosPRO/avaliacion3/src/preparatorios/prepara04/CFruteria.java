package preparatorios.prepara04;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CFruteria
{
    private CFruta[] fruteria;
    private int total;
    private ObjectOutputStream flujoSalida;
    private ObjectInputStream flujoEntrada;
    private File fichero;
    
    public CFruteria(final File fich) {
        this.fruteria = new CFruta[10];
        this.total = 0;
        this.fichero = fich;
    }
    
    public void llenar() {
        this.fruteria[0] = new CFruta("F01", "Aguacates", 52, 3.25f);
        this.fruteria[1] = new CFruta("F02", "Zanahorias", 34, 5.45f);
        this.fruteria[2] = new CFruta("F03", "Platanos", 57, 4.75f);
        this.fruteria[3] = new CFruta("F04", "Manzanas", 47, 2.85f);
        this.fruteria[4] = new CFruta("F05", "Mandarinas", 61, 3.55f);
        this.total = 5;
    }
    
    public void vaciar() {
        this.total = 0;
    }
    
    public void salvar() {
        if (this.total == 0) {
            System.out.println("Fruteria VACIA");
        }
        else {
            this.flujoSalida = null;
            try {
                this.flujoSalida = new ObjectOutputStream(new FileOutputStream(this.fichero));
                for (int i = 0; i < this.total; ++i) {
                    this.flujoSalida.writeObject(this.fruteria[i]);
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
                this.fruteria[i] = (CFruta)this.flujoEntrada.readObject();
                ++i;
            }
        }
        catch (ClassNotFoundException e) {
            System.out.println("problemas con la clase CFruta");
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
    
    private CFruta dameFruta(final String cod) {
        for (int i = 0; i < this.total; ++i) {
            if (this.fruteria[i].getCodigo().equals(cod)) {
                return this.fruteria[i];
            }
        }
        return null;
    }
    
    private int dameIndice(final String cod) {
        for (int i = 0; i < this.total; ++i) {
            if (this.fruteria[i].getCodigo().equals(cod)) {
                return i;
            }
        }
        return -1;
    }
    
    private void elimina(int i) {
        while (i < this.total - 1) {
            this.fruteria[i] = this.fruteria[i + 1];
            ++i;
        }
        --this.total;
    }
    
    public void eliminarFruta(final String codigo) {
        final int indice = this.dameIndice(codigo);
        if (indice == -1) {
            System.out.println("Fruta no ENCONTRADA");
        }
        else {
            this.elimina(indice);
            System.out.println("Fruta ELIMINADA");
        }
    }
    
    public void insertarFruta() {
        System.out.print("Dame c\u00f3digo: ");
        final String codigo = Leer.datoString();
        System.out.print("Dame nombre: ");
        final String nombre = Leer.datoString();
        System.out.print("Dame cantidad: ");
        final int cantidad = Leer.datoInt();
        System.out.print("Dame precio: ");
        final float precio = Leer.datoFloat();
        this.fruteria[this.total] = new CFruta(codigo, nombre, cantidad, precio);
        ++this.total;
    }
    
    public void modificarFruta(final String codigo) {
        final CFruta fruta = this.dameFruta(codigo);
        if (fruta == null) {
            System.out.println("fruta no ENCONTRADA");
        }
        else {
            System.out.println("Precio ACTUAL: " + fruta.getPrecio());
            System.out.print("Dame precio NUEVO: ");
            final float precio = Leer.datoFloat();
            fruta.setPrecio(precio);
            System.out.println("fruta MODIFICADA");
        }
    }
    
    public void mostrarFruta(final String codigo) {
        final CFruta fruta = this.dameFruta(codigo);
        if (fruta == null) {
            System.out.println("Fruta no ENCONTRADA");
        }
        else {
            this.mostrarCabecera();
            fruta.mostrar();
        }
    }
    
    public void mostrar() {
        if (this.total == 0) {
            System.out.println("Fruter\u00eda VACIA");
        }
        else {
            this.mostrarCabecera();
            for (int i = 0; i < this.total; ++i) {
                this.fruteria[i].mostrar();
            }
        }
    }
    
    private void mostrarCabecera() {
        System.out.println("CODIGO\t\tNOMBRE  \tCANTIDAD\tPRECIO");
        System.out.println("======\t\t======  \t========\t======");
    }
    
    private void menu() {
        System.out.println("\n  M E N U - 4");
        System.out.println("  ===========");
        System.out.println("1.- LLENAR fruteria");
        System.out.println("2.- VACIAR fruteria");
        System.out.println("3.- MOSTRAR fruteria");
        System.out.println("4.- MOSTRAR fruta");
        System.out.println("5.- INSERTAR fruta");
        System.out.println("6.- MODIFICAR fruta");
        System.out.println("7.- ELIMINAR fruta");
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
