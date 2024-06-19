package heranza;

public class Rectangulo extends Forma {

	public Rectangulo(int lado1, int lado2) {
		super(lado1, lado2);
	}

	public int calcularPerimetro() {
		this.setPerimetro(this.getLado1() + 2 + this.getLado2() * 2);
		return this.getPerimetro();
	}
	
	public int calcularSuperficie() {
		System.out.println("Este calculo foi rescrito en Reectangulo");
		System.out.println(super.calcularSuperficie());
		return super.calcularSuperficie();
	}
}