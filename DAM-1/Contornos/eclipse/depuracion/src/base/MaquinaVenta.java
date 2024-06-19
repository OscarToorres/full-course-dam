package base;

public class MaquinaVenta {

	private String[] nombre = new String[2];
	private float[] precio = new float[2];
	private int[] unidades = new int[2];

	public MaquinaVenta(String[] nombre, float[] precio, int[] unidades) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.unidades = unidades;
	}

	public MaquinaVenta() {
	}

	public boolean comprobacionStock() {
		boolean stock = true;

		for (int i = 0; unidades[i] != '\0'; i++) {
			if (unidades[i] == 0)
				stock = false;
		}	
		return stock;
	}

	public boolean aviso() {
		boolean aviso = false;

		for (int i = 0; unidades[i] != '\0'; i++) {
			if (unidades [i] <= 2)
				aviso = true;
		}	
		return aviso;
	}

	public static void main(String[] args) {
		String[] nombre = {"CocaCola", "Bocadillo"};
		int [] unidades = {13, 8};
		
		MaquinaVenta articulos = new MaquinaVenta();
		
		articulos.comprobacionStock();
		articulos.aviso();
		

		
	}
}
