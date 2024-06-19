// 
// Decompiled by Procyon v0.5.36
// 

package preparatorios.prepara02;

public class CFruteria
{
    private CFruta[] fruteria;
    private int total;
    
    public CFruteria() {
        this.fruteria = new CFruta[5];
        this.total = 0;
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
        System.out.println("\n  M E N U - 2");
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
