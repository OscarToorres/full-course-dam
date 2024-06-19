package refecion;

public class Alimento {
	private String nome;
	private int calorias;

	private int proteinas;
	private int lipidos;
	private int carbohidratos;

	public Alimento(String nome, int calorias, int proteinas, int lipidos, int carbohidratos) {
		super();
		this.nome = nome;
		this.calorias = calorias;
		this.proteinas = proteinas;
		this.lipidos = lipidos;
		this.carbohidratos = carbohidratos;

	}
	
	public void listaAlimentos() {
		Alimento a1 = new Alimento("Pan", 100, 10, 5, 85);
		Alimento a2 = new Alimento("Patacas", 120, 30, 25, 45);
		Alimento a3 = new Alimento("Sardiña", 200, 30, 40, 30);
		Alimento a4 = new Alimento("Mazá", 30, 5, 4, 90);
	}

	public String getNome() {
		return nome;
	}

	public int getCalorias() {
		return calorias;
	}

	public int getProteinas() {
		return proteinas;
	}

	public int getLipidos() {
		return lipidos;
	}

	public int getCarbohidratos() {
		return carbohidratos;
	}

	@Override
	public String toString() {
		return "Alimento \t" + nome + " \tcalorias=" + calorias + ", proteinas=" + proteinas + ", lipidos=" + lipidos
				+ ", carbohidratos=" + carbohidratos;
	}

}
