public class TestRacional {
    
    public static void main(String[]args){

        //Creacion del objeto de la clase Racional
        Racional racional1 = new Racional();

        // Creacion del primer numero racional
        racional1.asignarDatos(1, 3);
        System.out.println(racional1.visualizarRacinal());

        //Modificacion del primer numero racional
        racional1.asignarDatos(4, 6);
        System.out.println(racional1.visualizarRacinal());

    }
}
