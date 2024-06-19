package heranza;

public class Forma {

	private int lado1, lado2, superficie, perimetro;

	public Forma(int lado1, int lado2) {
		super();
		this.lado1 = lado1;
		this.lado2 = lado2;
	}

	public int getLado1() {
		return lado1;
	}

	public void setLado1(int lado1) {
		this.lado1 = lado1;
	}

	public int getLado2() {
		return lado2;
	}

	public void setLado2(int lado2) {
		this.lado2 = lado2;
	}
	
	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public int getPerimetro() {
		return perimetro;
	}

	public void setPerimetro(int perimetro) {
		this.perimetro = perimetro;
	}

	public int calcularSuperficie() {
		this.setSuperficie(this.getLado1() + this.getLado2());
		return this.getSuperficie();
	}
	
	@Override
	public String toString() {
		return "Forma [lado1=" + lado1 + ", lado2=" + lado2 + ", superficie=" + superficie + ", perimetro=" + perimetro
				+ "]";
	}
	
	
	
}
