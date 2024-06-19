package teoria.capitulo10;

import misClases.teoria.CCuentaCorrienteConIn;
import misClases.teoria.CCuentaCorriente;
import misClases.teoria.CCuentaAhorro;
import misClases.teoria.IFecha;

class CApFecha1
{
    public static void main(final String[] args) {
        final IFecha[] cuentas = new IFecha[3];
        final CCuentaAhorro cliente1 = new CCuentaAhorro();
        cuentas[0] = cliente1;
        ((CCuentaAhorro)cuentas[0]).asignarNombre("cliente1");
        System.out.println(((CCuentaAhorro)cuentas[0]).obtenerNombre());
        System.out.println(((CCuentaAhorro)cuentas[0]).intereses());
        final CCuentaCorriente cliente2 = new CCuentaCorriente();
        cuentas[1] = cliente2;
        ((CCuentaCorriente)cuentas[1]).asignarNombre("cliente2");
        System.out.println(((CCuentaCorriente)cuentas[1]).obtenerNombre());
        System.out.println(((CCuentaCorriente)cuentas[1]).intereses());
        final CCuentaCorrienteConIn cliente3 = new CCuentaCorrienteConIn();
        cuentas[2] = cliente3;
        ((CCuentaCorrienteConIn)cuentas[2]).asignarNombre("cliente3");
        System.out.println(((CCuentaCorrienteConIn)cuentas[2]).obtenerNombre());
        System.out.println(((CCuentaCorrienteConIn)cuentas[2]).intereses());
    }
}