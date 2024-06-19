package refecion;

import java.util.ArrayList;
import java.util.List;

public class RefecionApp {

	private static List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	
	public static void main(String[] args) {

		Alimento a1 = new Alimento("Pan", 100, 10, 5, 85);
		Alimento a2 = new Alimento("Patacas", 120, 30, 25, 45);
		Alimento a3 = new Alimento("Sardiña", 200, 30, 40, 30);
		Alimento a4 = new Alimento("Mazá", 30, 5, 4, 90);

		Ingrediente i1 = new Ingrediente(a1, 80);
		Ingrediente i2 = new Ingrediente(a2, 40);
		Ingrediente i3 = new Ingrediente(a3, 250);
		Ingrediente i4 = new Ingrediente(a4, 100);

		ingredientes.add(i1);
		ingredientes.add(i2);
		ingredientes.add(i3);
		ingredientes.add(i4);
		
		int opcion = Receta.solicitarOpcion();
		Receta.menu(opcion);
		
	}
}