package basico;

import java.util.Date;

public class BasicoApp {

		public static void main(String[] args) {
			Empregada empregada = new Empregada();
			
			empregada.setId(1);
			empregada.setNome("Carballo Neira, María");
			empregada.setDni(12345678H);
			empregada.setDataNacimiento(new Date());
			
			
		}
}
