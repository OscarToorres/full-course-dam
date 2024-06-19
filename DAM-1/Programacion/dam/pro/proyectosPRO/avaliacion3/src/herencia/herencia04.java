package herencia;

import misClases.avaliacion3.ClaseA;
import misClases.avaliacion3.ClaseD;
import misClases.avaliacion3.ClaseC;
import misClases.avaliacion3.ClaseB;

class herencia04
{
    public static void main(String[] args) {
        ClaseA aB = new ClaseB();
        ClaseA aC = new ClaseC();
        ClaseA aD = new ClaseD();
        System.out.println(aB.metodo_x());
        System.out.println(aC.metodo_x());
        System.out.println(aD.metodo_x());
    }
}