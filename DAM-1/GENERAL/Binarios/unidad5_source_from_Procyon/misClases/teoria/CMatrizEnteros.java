// 
// Decompiled by Procyon v0.5.36
// 

package misClases.teoria;

public class CMatrizEnteros
{
    private int[] matriz;
    
    public void crea() {
        System.out.print("Numero de enteros: ");
        final int nElementos = Leer.datoInt();
        this.matriz = new int[nElementos];
    }
    
    private int dameDato() {
        final int dato = (int)(31.0 * Math.random() + 20.0);
        return dato;
    }
    
    public void llena() {
        for (int i = 0; i < this.matriz.length; ++i) {
            this.matriz[i] = this.dameDato();
        }
    }
    
    public void amosa() {
        System.out.println("\nMatriz de Enteros");
        for (int i = 0; i < this.matriz.length; ++i) {
            System.out.print("  " + this.matriz[i]);
        }
    }
}
