package ejercicio05;

public class PruebaLetrasHilo {

	public static void main(String[] args) {
//		 LetrasHilos instancia = new LetrasHilos("esternocleidomastoideo");
		
		if (args.length != 1) {
			System.out.println("Hay que introducir un argumento");
			System.exit(0);
		}
		LetrasHilos instancia = new LetrasHilos(args[0]);
	}

}
	