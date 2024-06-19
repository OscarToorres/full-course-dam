package herencia;

import misClases.avaliacion3.ClaseA;
import misClases.avaliacion3.ClaseD;
import misClases.avaliacion3.ClaseC;
import misClases.avaliacion3.ClaseB;

class herencia05
{
    public static void main(final String[] args) {
        ClaseA a = new ClaseB();
        System.out.println(a.metodo_x());
        a = new ClaseC();
        System.out.println(a.metodo_x());
        a = new ClaseD();
        System.out.println(a.metodo_x());
    }
}