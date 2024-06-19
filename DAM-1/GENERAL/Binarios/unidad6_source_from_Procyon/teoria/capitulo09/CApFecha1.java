// 
// Decompiled by Procyon v0.5.36
// 

package teoria.capitulo09;

import misClases.teoria.Leer;
import misClases.teoria.CFecha;

class CApFecha1
{
    public static void visualizarFecha(final CFecha fecha) {
        final int[] f = new int[3];
        fecha.obtenerFecha(f);
        System.out.println(String.valueOf(f[0]) + "/" + f[1] + "/" + f[2]);
    }
    
    public static void main(final String[] args) {
        final CFecha fecha = new CFecha();
        do {
            System.out.print("dia, ##   :  ");
            final int dia = Leer.datoInt();
            System.out.print("mes, ##   :  ");
            final int mes = Leer.datoInt();
            System.out.print("anio #### :  ");
            final int anio = Leer.datoInt();
            fecha.asignarFecha(dia, mes, anio);
        } while (!fecha.fechaCorrecta());
        visualizarFecha(fecha);
    }
}
