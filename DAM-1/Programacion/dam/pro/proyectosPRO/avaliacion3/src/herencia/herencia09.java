package herencia;

import misClases.avaliacion3.ClaseA;
import misClases.avaliacion3.ClaseD;

class herencia09
{
    public static void main(final String[] args) {
        final ClaseA a = new ClaseD();
        System.out.println(a.metodo_y());
        System.out.println(a.metodo_x());
        System.out.println(((ClaseD)a).metodo_x(10));
    }
}