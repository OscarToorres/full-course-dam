package basico;

import java.util.Date;

public class PersonaApp {

	public static void main(String[] args) {

		Persona persona = new Persona("147526L", "Manuel", "Carballo", new Date(),
				"R�a Abc", "15960", "Ribeira", "Cour�a", "A");
				
		System.out.println(persona.toString());
		System.out.println();
	}

}
