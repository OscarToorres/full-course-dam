package base;

public class Pintar {

	private float superficie;
	private float precioPintura;
	private float rendimiento;
	private float total = 0;
	
	public float getSuperficie() {
		return superficie;
	}


	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}


	public float getPrecioPintura() {
		return precioPintura;
	}


	public void setPrecioPintura(float precioPintura) {
		this.precioPintura = precioPintura;
	}


	public float getRendimiento() {
		return rendimiento;
	}


	public void setRendimiento(float rendimiento) {
		this.rendimiento = rendimiento;
	}


	
	private float calculo () {
		total = superficie * precioPintura * rendimiento;
		return total;
	}
	
	public static void main(String[] args) {
		
		Pintar precio = new Pintar();

		precio.setSuperficie(2);
		precio.setPrecioPintura(2);
		precio.setRendimiento(2);
		
		System.out.println(precio.calculo());
	}
}