package teoria.capitulo09;

import misClases.teoria.CVector;

class CApVector
{
    public static void visualizarVector(final CVector v) {
        for (int ne = v.longitud(), i = 0; i < ne; ++i) {
            System.out.print(String.valueOf(v.valorEn(i)) + " ");
        }
        System.out.println();
    }
    
    public static void main(final String[] args) {
        final double[] x = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0 };
        final CVector vector1 = new CVector();
        final CVector vector2 = new CVector(5);
        final CVector vector3 = new CVector();
        for (int i = 0; i < vector2.longitud(); ++i) {
            vector3.ponerValorEn(i, (i + 1) * 10);
        }
        final CVector vector4 = new CVector(vector3);
        final CVector vector5 = new CVector(x);
        visualizarVector(vector1);
        visualizarVector(vector2);
        visualizarVector(vector3);
        visualizarVector(vector4);
        visualizarVector(vector5);
        System.out.println();
        vector1.copiar(vector5);
        if (vector1 == vector5) {
            System.out.println("referencias al mismo objeto");
        }
        else {
            System.out.println("referencias a objetos diferentes");
        }
        if (vector1.equals(vector5)) {
            System.out.println("objetos iguales");
        }
        else {
            System.out.println("objetos diferentes");
        }
        visualizarVector(vector1);
        visualizarVector(vector5);
    }
}
