package teoria.capitulo10;

import misClases.teoria.CCuentaAhorro;
import misClases.teoria.ESaldoInsuficiente;

class CApCuenta
{
    public static void main(final String[] args) throws ESaldoInsuficiente {
        primerCliente();
        segundoCliente();
        final Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        runtime.runFinalization();
    }
    
    private static void primerCliente() throws ESaldoInsuficiente {
        final CCuentaAhorro cliente01 = new CCuentaAhorro();
        cliente01.asignarNombre("Amancio Couso Arias");
        cliente01.asignarCuenta("123456789");
        cliente01.asignarTipoDeInteres(2.5);
        cliente01.asignarCuotaManten(300.0);
        cliente01.ingreso(1000000.0);
        cliente01.reintegro(35000.0);
        cliente01.comisiones();
        System.out.println(cliente01.obtenerNombre());
        System.out.println(cliente01.obtenerCuenta());
        System.out.println(cliente01.estado());
        System.out.println(cliente01.obtenerTipoDeInteres());
        System.out.println(cliente01.obtenerCuotaManten());
    }
    
    private static void segundoCliente() throws ESaldoInsuficiente {
        final CCuentaAhorro cliente02 = new CCuentaAhorro("Benancio Compostela Rivera", "987654321", 1000000.0, 4.5, 400.0);
        cliente02.ingreso(200000.0);
        cliente02.reintegro(70000.0);
        cliente02.comisiones();
        System.out.println(cliente02.obtenerNombre());
        System.out.println(cliente02.obtenerCuenta());
        System.out.println(cliente02.estado());
        System.out.println(cliente02.obtenerTipoDeInteres());
        System.out.println(cliente02.obtenerCuotaManten());
    }
}