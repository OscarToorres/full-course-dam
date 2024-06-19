package herencia;

import misClases.avaliacion3.ClaseD;
import misClases.avaliacion3.ClaseC;
import misClases.avaliacion3.ClaseB;
import misClases.avaliacion3.ClaseA;

class herencia06
{
    public static void main(final String[] args) {
        final ClaseA[] a = { new ClaseB(), new ClaseC(), new ClaseD() };
        for (int i = a.length - 1; i >= 0; --i) {
            System.out.println(a[i].metodo_x());
        }
    }
}