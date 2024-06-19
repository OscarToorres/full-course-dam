package cualificar;

public class CualificarApp {

	public static void main(String[] args) {

		Cualificar cualificar = new Cualificar("Carballo Meira, Antia", 6, 3, "12345678A");
		if (cualificar.aprobado() == false)
			System.out.println("Proba executada con exito");
		else
			System.out.println("Proba executada con erros");
//------------------------------------------------------------------
		cualificar.setNome("Mendez Díaz, Carlos");
		cualificar.setDni("01010101A");
		cualificar.setModulo(10);
		cualificar.setCualificacion(9);
//------------------------------------------------------------------
		if (cualificar.aprobado() == true)
			System.out.println("Proba executada con exito");
		else
			System.out.println("Proba executada con erros");
		
		cualificar.setCualificacion(51);
	}
}