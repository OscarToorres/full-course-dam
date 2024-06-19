package basico;

import java.util.Date;

public class PersonaApp {

	public static void main(String[] args) {

		Persona persona = new Persona("147526L", "Manuel", "Carballo", new Date(),
				"Rúa Abc", "15960", "Ribeira", "Courña", "A");
				
		System.out.println(persona.toString());
		System.out.println();
	}

}
