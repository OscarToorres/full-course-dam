package misClases.avaliacion3;

public class ClaseA
{
    public int atributo_x;
    
    public ClaseA() {
        this.atributo_x = 1;
    }
    
    public int metodo_x() {
        System.out.println("Metodo X de la ClaseA");
        return this.atributo_x * 10;
    }
    
    public int metodo_y() {
        System.out.println("Metodo Y de la ClaseA");
        return this.atributo_x + 100;
    }
}