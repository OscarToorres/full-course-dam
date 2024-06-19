// 
// Decompiled by Procyon v0.5.36
// 

package teoria.capitulo07;

import misClases.teoria.CMatrizReales;

class CApMatrizReales
{
    public static void main(final String[] args) {
        final CMatrizReales matriz = new CMatrizReales();
        matriz.crea();
        matriz.llena();
        matriz.amosa();
        System.out.println("\nModificamos Elemento");
        final int indice = matriz.dameIndice();
        matriz.modificaElemento(indice);
        matriz.amosa();
    }
}
