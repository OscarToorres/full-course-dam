package consumo;

import java.util.Scanner;

public class ConsumoApp {

	private static final String PERCORRIDO = "Distancia percorrida: ";
	private static final String CONSUMO = "Combustíbel consumido, litros: ";
	private static final String OPCION = "Indica unha opción";
	private static final String MEDIA = "Consumo medio";
	private static final String PORCENTUAL = "Consumo porcentual";
	private static final String ESTIMADO = "Consumo estimado";

	public static void main(String[] args) {

		Consumo[] consumos = new Consumo[] { new Consumo(100, 7), new Consumo(200, 11), new Consumo(100, 8),
				new Consumo(60, 4) };

		Percorrido percorrido = new Percorrido(consumos);
		System.out.print(PERCORRIDO);
		System.out.println(percorrido.calcularDistancia());
		System.out.print(CONSUMO);
		System.out.println(percorrido.calcularLitros());
		System.out.print(OPCION + "\n\t1." + MEDIA + "\n\t2." + PORCENTUAL + "\n\t3." + ESTIMADO + "\n");
		int opcion = new Scanner(System.in).nextInt();
		int distancia = 0; 
		percorrido.menu(opcion, distancia);
	}
}