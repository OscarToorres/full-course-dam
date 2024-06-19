package base;

public class Viaje {

	private static final float CONSUMO1 = 0.07f;
	private static final float CONSUMO2= 0.09f;
	private float distancia = 0;
	private float velocidadMedia = 0;
	private float precioGasolina = 0;
	private float coste;
	
	
	public float getDistancia() {
		return distancia;
	}

	public void setDistancia(float distancia) {
		if (distancia >= 0)
			this.distancia = distancia;
		
	}

	public float getVelocidadMedia() {
		return velocidadMedia;
	}

	public void setVelocidadMedia(float velocidadMedia) {
		if (velocidadMedia >= 0)
			this.velocidadMedia = velocidadMedia;
	}

	public float getPrecioGasolina() {
		return precioGasolina;
	}

	public void setPrecioGasolina(float precioGasolina) {
		if (precioGasolina >= 0)
			this.precioGasolina = precioGasolina;
	}

	public float calculo() {
		System.out.println(distancia);
		System.out.println(precioGasolina);
		System.out.println(velocidadMedia);
		if (velocidadMedia <= 100.0)
			coste= distancia * CONSUMO1 * precioGasolina;
		else 
			coste = distancia * CONSUMO2 * precioGasolina;
		return coste;
		
	}

	public static void main(String[] args) {
		
		Viaje viaje = new Viaje();
		
		viaje.setDistancia(100);
		viaje.setVelocidadMedia(100);
		viaje.setPrecioGasolina(2);
		System.out.println(viaje.calculo());
	}

}
