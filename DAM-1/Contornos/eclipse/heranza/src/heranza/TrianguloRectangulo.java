package heranza;

public class TrianguloRectangulo extends Forma{

	public TrianguloRectangulo(int lado1, int lado2) {
		super(lado1, lado2);
	}
	
	public int calcularPerimetro() {
		this.setPerimetro(this.getLado1() * 3);
		return this.getPerimetro();
	}

	public int calcularSuperficie() {
		this.setSuperficie((this.getLado1() * this.getLado2()) / 2);
		return this.getSuperficie();
	}
}