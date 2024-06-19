// 
// Decompiled by Procyon v0.5.36
// 

package teoria.capitulo09;

import misClases.teoria.CFecha;

class CApFecha2
{
    public static void visualizarFecha(final CFecha fecha) {
        final int[] f = new int[3];
        fecha.obtenerFecha(f);
        System.out.println(String.valueOf(f[0]) + "/" + f[1] + "/" + f[2]);
    }
    
    public static void main(final String[] args) {
        final CFecha fecha1 = new CFecha();
        final CFecha fecha2 = new CFecha(3);
        final CFecha fecha3 = new CFecha(15, 3);
        final CFecha fecha4 = new CFecha(1, 3, 2002);
        visualizarFecha(fecha1);
        visualizarFecha(fecha2);
        visualizarFecha(fecha3);
        visualizarFecha(fecha4);
        System.out.println();
        fecha1.copiar(fecha2.copiar(fecha3));
        final CFecha fecha5 = new CFecha(fecha1);
        visualizarFecha(fecha1);
        visualizarFecha(fecha2);
        visualizarFecha(fecha3);
        visualizarFecha(fecha4);
        visualizarFecha(fecha5);
    }
}
