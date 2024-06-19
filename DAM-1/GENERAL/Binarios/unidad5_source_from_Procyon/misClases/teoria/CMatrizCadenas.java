// 
// Decompiled by Procyon v0.5.36
// 

package misClases.teoria;

import misClases.utilidades.DatosPersonales;

public class CMatrizCadenas
{
    private char[][] matriz;
    private int nElementos;
    
    public void crea() {
        System.out.print("Numero de personas: ");
        this.nElementos = Leer.datoInt();
        this.matriz = new char[this.nElementos][];
    }
    
    private char[] dameDato() {
        String dato = DatosPersonales.dameNombre();
        dato = String.valueOf(dato) + " " + DatosPersonales.dameApellido();
        dato = String.valueOf(dato) + " " + DatosPersonales.dameApellido();
        return dato.toCharArray();
    }
    
    public void llena() {
        for (int i = 0; i < this.nElementos; ++i) {
            this.matriz[i] = this.dameDato();
        }
    }
    
    public void amosa() {
        System.out.println("\nMatriz de Personas");
        for (int i = 0; i < this.nElementos; ++i) {
            final int longitud = this.matriz[i].length;
            System.out.print(String.valueOf(i) + "->  ");
            System.out.print(this.matriz[i]);
            System.out.println(" (" + longitud + ")");
        }
    }
    
    public int dameIndice() {
        int indice;
        do {
            System.out.print("Dame indice: ");
            indice = Leer.datoInt();
        } while (indice < 0 || indice > this.nElementos - 1);
        return indice;
    }
    
    public void anulaElemento(final int indice) {
        for (int i = indice; i < this.nElementos - 1; ++i) {
            this.matriz[i] = this.matriz[i + 1];
        }
        --this.nElementos;
    }
}
