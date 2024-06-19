package consumo;

public class Percorrido {

	private Consumo[] consumos;
	private static final String MEDIA = "Consumo medio";
	private static final String PORCENTUAL= "Consumo porcentual";
	private static final String ESTIMADO = "Consumo estimado, dixite a distancia: ";
	private static final String LITROS = "Litros = ";	

	public Percorrido(Consumo[] consumos) {
		super();
		this.consumos = consumos;
	}
	
	public void menu(int opcion, int distancia) {
		if(opcion == 1) {
			System.out.print(MEDIA);
			System.out.println(this.calcularConsumoMedio());
		}else if (opcion == 2) {
			System.out.print(PORCENTUAL);
			System.out.println(this.calcularConsumoPorcentual());
		}else if(opcion == 3) {
			System.out.println(ESTIMADO);
			System.out.println(LITROS + this.calcularConsumoEstimado(distancia));
		}else {}
		}
	

	public int calcularLitros() {
		int total = 0;

		for (Consumo consumo : consumos) {
			total += consumo.getConsumoLitros();
		}
		return total;
	}

	public int calcularDistancia() {
		int total = 0;

		for (Consumo consumo : consumos) {
			total += consumo.getDistancia();
		}
		return total;
	}

	public float calcularConsumoMedio() {
		float media = 0;
		for (Consumo consumo : consumos) {
			media += consumo.getConsumoLitros();
		}
		return media / consumos.length;
	}

	public float calcularConsumoPorcentual() {
		float porcentual = 0;
		porcentual = (100 * this.calcularLitros())/this.calcularDistancia();
		return porcentual;
	}
	
	public float calcularConsumoEstimado(int distancia) {
		return this.calcularConsumoMedio() * distancia / 100;
	}
	
}
