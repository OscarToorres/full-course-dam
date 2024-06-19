package tarea3_5;

public class Avaliacion {

	private Alumna alumna;
	private int[] cualificacions;

	public Avaliacion(Alumna alumna) {
		super();
		this.alumna = alumna;
		this.cualificacions = this.alumna.getCualificacions();
	}

	public boolean validacion() {
		boolean ok = false;
		for (int k = 0; k < this.cualificacions.length; k++) {
			if (this.cualificacions[k] <= 1)
				return ok;
		}
		ok = true;
		return ok;
	}

	public double cualificacionFinal() {
		double media = 0.0;

		if (this.validacion() == true) {
			for (int k = 0; k < this.alumna.getCualificacions().length; k++) {
				media += this.cualificacions[k];
			}
			media /= this.cualificacions.length;
		}
		return media;
	}

	public static void main(String[] args) {

		int[] cualificacion = new int[] { 5, 5, 5, 5, 5 };
		Alumna alumna = new Alumna("Manuel", "DAM", "CD", 1, cualificacion);
		double esperado = 5;
		Avaliacion avaliacion = new Avaliacion(alumna);
		if (esperado == avaliacion.cualificacionFinal()) {
			System.out.println("Prueba acertada");
		}else {
			System.out.println("Prueba erronea");
		}
	}
}