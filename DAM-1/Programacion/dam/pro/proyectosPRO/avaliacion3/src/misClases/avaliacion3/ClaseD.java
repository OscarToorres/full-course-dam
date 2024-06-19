package misClases.avaliacion3;

public class ClaseD extends ClaseA
{
    protected int atributo_x;
    
    public ClaseD() {
        this.atributo_x = 4;
    }
    
    public int metodo_x() {
        System.out.println("Metodo X de la ClaseD");
        return this.atributo_x * -10;
    }
    
    public int metodo_x(final int a) {
        System.out.println("Metodo X(int) de la ClaseD");
        return super.atributo_x * -a;
    }
    
    public int metodo_z() {
        System.out.println("Metodo Z de la ClaseD");
        return this.atributo_x * -20;
    }
}