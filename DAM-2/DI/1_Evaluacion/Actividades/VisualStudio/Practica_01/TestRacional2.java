public class TestRacional2 {
    
    public static void main (String [] args) {

        Racional2 r1 = new Racional2(1, 3);
        Racional2 r2 = new Racional2();
        Racional2 racional2 = new Racional2();

        System.out.println(racional2.sumarRacional(r1, r2));
        System.out.println(racional2.restarRacional(r1, r2));
        System.out.println(racional2.multiplicarRacional(r1, r2));
        System.out.println(racional2.dividirRacional(r1, r2));

    }
}

