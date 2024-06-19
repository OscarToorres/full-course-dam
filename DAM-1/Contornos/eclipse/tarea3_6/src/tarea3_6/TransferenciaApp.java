package tarea3_6;

public class TransferenciaApp {

	public static void main(String[] args) {

		Clienta orixe = new Clienta("1A", 100);
        Clienta destino = new Clienta("2B", 200);

        Transferencia transferencia = new Transferencia(orixe, destino);
        double cantidade = 200;
        boolean ok = transferencia.transferencia(cantidade);
        String prueba = transferencia.mensaxeok();
        System.out.println(prueba);
        
        cantidade = 50;
        ok = transferencia.transferencia(cantidade);
        prueba = transferencia.mensaxeok();
        System.out.println(prueba);
        
	}
}