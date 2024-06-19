package Boletin_07;

public class MostrarNome {
    public static void main(String[] args) {
        if (args.length <= 0){
            System.out.println("Necesito un NAME");
            System.exit(-1);
        }
        System.out.println(args[0]);
    }  
}