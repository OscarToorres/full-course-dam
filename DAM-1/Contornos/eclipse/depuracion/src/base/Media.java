package base;

public class Media {
	
	private double [] nota = new double[3];

	public Media(double[] nota) {
		super();
		this.nota = nota;
	}

	public double media () {
		double suma = 0;
		for (int i = 0; i < this.nota.length; i++)
			suma = nota[i] + suma;
		return suma/3;
	}

	public static void main(String[] args) {
		double [] nota = {5, 5, 5};
		
		Media media = new Media(nota);
		System.out.println(media.media());
	}

}
