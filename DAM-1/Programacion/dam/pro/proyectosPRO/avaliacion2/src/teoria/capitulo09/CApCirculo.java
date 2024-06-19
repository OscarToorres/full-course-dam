package teoria.capitulo09;

import misClases.teoria.CCirculo;

public class CApCirculo
{
    public static void main(final String[] args) {
        System.out.println(CCirculo.seno[90]);
        System.out.println(CCirculo.coseno[90]);
        System.out.println(CCirculo.coseno[180]);
        System.out.println();
        final CCirculo obj1 = new CCirculo();
        System.out.println(obj1.longCircunferencia());
        System.out.println(obj1.CreaCirculo());
        final CCirculo obj2 = new CCirculo(100.0, 100.0, 10.0);
        System.out.println(obj2.longCircunferencia());
        System.out.println(obj2.CreaCirculo());
        System.out.println();
        System.out.println(" Valor de Pi :" + CCirculo.damePi());
        CCirculo.cambiarPrecisionPiA(3.1411);
        System.out.println(" Valor de Pi :" + CCirculo.damePi());
        System.out.println();
        System.out.println(CCirculo.numCirculos);
        System.out.println(obj1.longCircunferencia());
        System.out.println(obj1.CreaCirculo());
        System.out.println(obj2.longCircunferencia());
        System.out.println(obj2.CreaCirculo());
    }
}
