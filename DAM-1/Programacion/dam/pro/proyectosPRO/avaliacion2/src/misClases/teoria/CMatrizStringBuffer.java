package misClases.teoria;

import misClases.utilidades.DatosPersonales;

public class CMatrizStringBuffer
{
    private StringBuffer[] matriz;
    
    public void crea() {
        System.out.print("Numero de personas: ");
        final int n = Leer.datoInt();
        this.matriz = new StringBuffer[n];
    }
    
    private StringBuffer dameDato() {
        final StringBuffer dato = new StringBuffer(DatosPersonales.dameNombre());
        dato.append(" ").append(DatosPersonales.dameApellido());
        dato.append(" ").append(DatosPersonales.dameApellido());
        return dato;
    }
    
    public void llena() {
        for (int i = 0; i < this.matriz.length; ++i) {
            this.matriz[i] = this.dameDato();
        }
    }
    
    public void amosa() {
        System.out.println("\nMatriz de Personas");
        for (int i = 0; i < this.matriz.length; ++i) {
            final int longitud = this.matriz[i].length();
            System.out.println(String.valueOf(i) + "->  " + this.matriz[i].toString() + " (" + longitud + ")");
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
}
