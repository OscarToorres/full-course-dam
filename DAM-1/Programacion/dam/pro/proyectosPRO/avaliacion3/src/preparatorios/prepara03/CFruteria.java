package preparatorios.prepara03;

import java.io.EOFException;
import java.io.FileInputStream;
import java.util.Iterator;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

public class CFruteria
{
    private ArrayList<CFruta> fruteria;
    private DataOutputStream flujoSalida;
    private DataInputStream flujoEntrada;
    private File fichero;
    
    public CFruteria(final File fich) {
        this.fruteria = new ArrayList<CFruta>();
        this.fichero = fich;
    }
    
    public void llenar() {
        this.fruteria.removeAll(this.fruteria);
        this.fruteria.add(new CFruta("F01", "Aguacates", 52, 3.25f));
        this.fruteria.add(new CFruta("F02", "Zanahorias", 34, 5.45f));
        this.fruteria.add(new CFruta("F03", "Platanos", 57, 4.75f));
        this.fruteria.add(new CFruta("F04", "Manzanas", 47, 2.85f));
        this.fruteria.add(new CFruta("F05", "Mandarinas", 61, 3.55f));
    }
    
    public void vaciar() {
        this.fruteria.removeAll(this.fruteria);
    }
    
    public void salvar() {
        final Iterator<CFruta> iterator = this.fruteria.iterator();
        this.flujoSalida = null;
        try {
            this.flujoSalida = new DataOutputStream(new FileOutputStream(this.fichero));
            while (iterator.hasNext()) {
                final CFruta fruta = iterator.next();
                this.flujoSalida.writeUTF(fruta.getCodigo());
                this.flujoSalida.writeUTF(fruta.getNombre());
                this.flujoSalida.writeInt(fruta.getCantidad());
                this.flujoSalida.writeFloat(fruta.getPrecio());
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
            this.fruteria.removeAll(this.fruteria);
            while (true) {
                final String codigo = this.flujoEntrada.readUTF();
                final String nombre = this.flujoEntrada.readUTF();
                final int cantidad = this.flujoEntrada.readInt();
                final float precio = this.flujoEntrada.readFloat();
                this.fruteria.add(new CFruta(codigo, nombre, cantidad, precio));
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
    
    private CFruta dameFruta(final String cod) {
        for (final CFruta fruta : this.fruteria) {
            if (fruta.getCodigo().equals(cod)) {
                return fruta;
            }
        }
        return null;
    }
    
    public void eliminarFruta(final String codigo) {
        final CFruta fruta = this.dameFruta(codigo);
        if (fruta == null) {
            System.out.println("Fruta no ENCONTRADA");
        }
        else {
            this.fruteria.remove(fruta);
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
        this.fruteria.add(new CFruta(codigo, nombre, cantidad, precio));
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
            System.out.println("fruta no ENCONTRADO");
        }
        else {
            this.mostrarCabecera();
            fruta.mostrar();
        }
    }
    
    public void mostrar() {
        final Iterator<CFruta> iterator = this.fruteria.iterator();
        if (this.fruteria.isEmpty()) {
            System.out.println("Fruteria VACIA");
        }
        else {
            this.mostrarCabecera();
            while (iterator.hasNext()) {
                iterator.next().mostrar();
            }
        }
    }
    
    private void mostrarCabecera() {
        System.out.println("CODIGO\t\tNOMBRE  \tCANTIDAD\tPRECIO");
        System.out.println("======\t\t======  \t========\t======");
    }
    
    private void menu() {
        System.out.println("\n  M E N U - 3");
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
