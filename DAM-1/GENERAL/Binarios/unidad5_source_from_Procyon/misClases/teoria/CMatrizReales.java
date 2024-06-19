// 
// Decompiled by Procyon v0.5.36
// 

package misClases.teoria;

public class CMatrizReales
{
    private float[] matriz;
    
    public void crea() {
        System.out.print("Numero de reales: ");
        final int nElementos = Leer.datoInt();
        this.matriz = new float[nElementos];
    }
    
    public void llena() {
        for (int i = 0; i < this.matriz.length; ++i) {
            this.matriz[i] = this.dameDato();
        }
    }
    
    public void amosa() {
        System.out.println("\nMatriz de Reales");
        for (int i = 0; i < this.matriz.length; ++i) {
            System.out.println(String.valueOf(i) + "->  " + this.matriz[i]);
        }
    }
    
    public int dameIndice() {
        int indice;
        do {
            System.out.print("Dame indice: ");
            indice = Leer.datoInt();
        } while (indice < 0 || indice > this.matriz.length - 1);
        return indice;
    }
    
    public void modificaElemento(final int indice) {
        this.matriz[indice] = this.dameDato();
    }
    
    private float dameDato() {
        final int dato1 = (int)(10.0 * Math.random());
        final int dato2 = (int)(100.0 * Math.random());
        final float dato3 = dato1 + dato2 / 100.0f;
        return dato3;
    }
}
