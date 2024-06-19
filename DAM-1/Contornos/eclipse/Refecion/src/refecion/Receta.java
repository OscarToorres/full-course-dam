package refecion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Receta {

	private static List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	private final static String LISTA = "Lista de ingredientes da dieta";
	private final static String PESO = "Peso dos ingredientes da dieta";
	private final static String PORCETAJE = "Porcentaxes da composición";
	private final static String CALORIAS = "Calorías totais da dieta especificada";
	private final static String OPCION = "Selecciona unha opción";

	public static void menu(int opcion) {
		if (opcion == 1) {
			System.out.println(LISTA);
			Receta.verListadeIngredientes();
		} else if (opcion == 2) {
			System.out.println(PESO);
			System.out.println(Receta.calcularPesoIngredientes());
		} else if (opcion == 3) {
			System.out.println(PORCETAJE);
			Receta.calcularPorcentajeIngredientes();
		} else if (opcion == 4) {
			System.out.println(CALORIAS);
			Receta.calcularCaloriasTotales();
		}
	}

	public static int solicitarOpcion() {

		System.out.println(OPCION);
		Scanner scanner = new Scanner(System.in);
		int opcion = scanner.nextInt();
		return opcion;
	}

	public static void verListadeIngredientes() {
		for (Ingrediente ingrediente : ingredientes) {
			System.out.println(ingrediente.getAlimento());
		}
	}

	public static int calcularPesoIngredientes() {
		int peso = 0;
		for (Ingrediente ingrediente : ingredientes)
			peso += ingrediente.getCantidade();
		return peso;
	}

	public static void calcularPorcentajeIngredientes() {
		int porcentaje = 0;
		int total = calcularPesoIngredientes();
		for (Ingrediente ingrediente : ingredientes) {
			porcentaje = ingrediente.getCantidade() * 100 / total;
			System.out.println(ingrediente.getAlimento().getNome() + " - > " + porcentaje);
		}
	}

	public static void calcularCaloriasTotales() {
		int total = 0;
		for (Ingrediente ingrediente : ingredientes) {
			total = ingrediente.getAlimento().getCalorias() * ingrediente.getCantidade() / 100;
			System.out.println(ingrediente.getAlimento().getNome() + " - > " + total);
		}
	}
}
