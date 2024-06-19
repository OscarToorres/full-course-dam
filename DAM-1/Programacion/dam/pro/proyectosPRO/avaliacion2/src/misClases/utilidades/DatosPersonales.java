package misClases.utilidades;

public class DatosPersonales {

	private static String[] nombres = new String[20];
	private static String[] apellidos = new String[21];

	public static String dameNombre() {
		nombres[0] = "Juan";
		nombres[1] = "Manuel";
		nombres[2] = "María";
		nombres[3] = "Carmen";
		nombres[4] = "Josefa";
		nombres[5] = "Isabel";
		nombres[6] = "Pilar";
		nombres[7] = "Dolores";
		nombres[8] = "Laura";
		nombres[9] = "Teresa";
		nombres[10] = "Antonio";
		nombres[11] = "Francisco";
		nombres[12] = "David";
		nombres[13] = "Antonio";
		nombres[14] = "Javier";
		nombres[15] = "Luis";
		nombres[16] = "Daniel";
		nombres[17] = "Arturo";
		nombres[18] = "Ana";
		nombres[19] = "Jose";
		int i = (int) (Math.random() * 20);
		return nombres[i];
	}

	public static String dameApellido() {
		apellidos[0] = "Torres";
		apellidos[1] = "Rodriguez";
		apellidos[2] = "Garcia";
		apellidos[3] = "Gonzalez";
		apellidos[4] = "Fernandez";
		apellidos[5] = "Lopez";
		apellidos[6] = "Martinez";
		apellidos[7] = "Sanchez";
		apellidos[8] = "Perez";
		apellidos[9] = "Gomez";
		apellidos[10] = "Martin";
		apellidos[11] = "Jimenez";
		apellidos[12] = "Hernandez";
		apellidos[13] = "Ruiz";
		apellidos[14] = "Diaz";
		apellidos[15] = "Moreno";
		apellidos[16] = "Muñoz";
		apellidos[17] = "Alvarez";
		apellidos[18] = "Romero";
		apellidos[19] = "Gutierrez";
		apellidos[20] = "Alonso";
		int i = (int) (Math.random() * 21);
		return apellidos[i];

	}

}
