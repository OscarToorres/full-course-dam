package consumo;

public class Consumo {

	private int distancia;
	private int consumoLitros;

	public Consumo(int distancia, int consumoLitros) {
		super();
		this.distancia = distancia;
		this.consumoLitros = consumoLitros;
	}
		
	public int getDistancia() {
		return distancia;
	}

	public int getConsumoLitros() {
		return consumoLitros;
	}

	@Override
	public String toString() {
		return "Consumo [distancia=" + distancia + ", consumoLitros=" + consumoLitros + "]";
	}

}
