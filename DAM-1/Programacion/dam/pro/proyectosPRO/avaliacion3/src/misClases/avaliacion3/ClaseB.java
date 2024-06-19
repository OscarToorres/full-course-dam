package misClases.avaliacion3;

public class ClaseB extends ClaseA
{
    protected int atributo_x;
    
    public ClaseB() {
        this.atributo_x = 2;
    }
    
    public int metodo_x() {
        System.out.println("Metodo X de la ClaseB");
        return this.atributo_x * -10;
    }
}