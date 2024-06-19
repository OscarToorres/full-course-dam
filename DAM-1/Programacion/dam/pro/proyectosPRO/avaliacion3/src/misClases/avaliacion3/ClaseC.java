package misClases.avaliacion3;

public class ClaseC extends ClaseA
{
    protected int atributo_x;
    
    public ClaseC() {
        this.atributo_x = 3;
    }
    
    @Override
    public int metodo_x() {
        System.out.println("Metodo X de la ClaseC");
        return this.atributo_x * -10;
    }
}