// 
// Decompiled by Procyon v0.5.36
// 

package preparatorios.prepara01;

import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;

public class CFruteria
{
    private ArrayList<CFruta> fruteria;
    
    public CFruteria() {
        this.fruteria = new ArrayList<CFruta>();
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
        System.out.println("\n  M E N U - 1");
        System.out.println("  ===========");
        System.out.println("1.- LLENAR fruteria");
        System.out.println("2.- VACIAR fruteria");
        System.out.println("3.- MOSTRAR fruteria");
        System.out.println("4.- MOSTRAR fruta");
        System.out.println("5.- ELIMINAR fruta");
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
