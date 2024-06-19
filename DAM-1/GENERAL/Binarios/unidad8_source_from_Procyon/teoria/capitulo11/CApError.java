// 
// Decompiled by Procyon v0.5.36
// 

package teoria.capitulo11;

import misClases.teoria.CCuentaCorrienteConIn;
import misClases.teoria.CCuentaCorriente;
import misClases.teoria.ESaldoInsuficiente;
import misClases.teoria.CCuentaAhorro;
import misClases.teoria.IFecha;

public class CApError
{
    public static void main(final String[] args) {
        final IFecha[] cuentas = new IFecha[3];
        final CCuentaAhorro cliente1 = new CCuentaAhorro();
        cuentas[0] = cliente1;
        ((CCuentaAhorro)cuentas[0]).asignarNombre("CLIENTE1");
        try {
            ((CCuentaAhorro)cuentas[0]).reintegro(1000.0);
        }
        catch (ESaldoInsuficiente e) {
            System.out.println(e.mensaje());
        }
        final CCuentaCorriente cliente2 = new CCuentaCorriente();
        cuentas[1] = cliente2;
        ((CCuentaCorriente)cuentas[1]).asignarNombre("CLIENTE2");
        try {
            ((CCuentaCorriente)cuentas[1]).reintegro(2000.0);
        }
        catch (ESaldoInsuficiente e2) {
            System.out.println(e2.mensaje());
        }
        final CCuentaCorrienteConIn cliente3 = new CCuentaCorrienteConIn();
        cuentas[2] = cliente3;
        ((CCuentaCorrienteConIn)cuentas[2]).asignarNombre("CLIENTE3");
        try {
            ((CCuentaCorrienteConIn)cuentas[2]).reintegro(3000.0);
        }
        catch (ESaldoInsuficiente e3) {
            System.out.println(e3.mensaje());
        }
    }
}
