package pruebas;

public class Prueba {
	
	private int[] vector = new int[] {1,2,3,4,5,6};

	public int sumaA_B(int a, int b) {
		int dato;
		if (a == b)
			dato = a;
		else
			dato = a + sumaA_B(a + 1, b);
		return dato;
	}
	
	public static void main (String [] args) {
		
		Prueba prueba = new Prueba();
		
		int a= 5,b=9;
		System.out.println(		prueba.sumaA_B(a,b));
	}

}

	
	
	

