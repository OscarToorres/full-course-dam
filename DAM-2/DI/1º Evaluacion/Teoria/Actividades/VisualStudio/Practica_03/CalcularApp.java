public class CalcularApp {

    public static void main(String[] args) {

        //Decalaracion de Objetos

        Operaciones operando = new Operaciones();
        NumeroEntero n1 = new NumeroEntero(1);
        NumeroEntero n2 = new NumeroEntero(2);

        //Aplicacion de metodos

        System.out.println(operando.suma(n1, n2));
        System.out.println(operando.resta(n1, n2));
        System.out.println(operando.comparacion(n1, n2));


        

    }

    

    



    

    
}
