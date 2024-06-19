package base;

public class MediaModificado {

	private double [] nota = new double[3];
	boolean avaliable = true;

	public MediaModificado(double[] nota) {
		super();
		if (this.nota.length >= 1 && this.nota.length <= 10)
			this.nota = nota;
	}

	public boolean avaliable () {
		int i = 0;
		int j = 0;
		for (i = 0; i < this.nota.length; i++) {
			if (nota[i] >= 1 && nota[i] <= 10)
				j++;
		}
		
		if (j == this.nota.length)
			return avaliable;
		else
			return avaliable = false;
	}
	
	public double media () {
		double suma = 0;
		if (avaliable == true) {
		for (int i = 0; i < this.nota.length; i++)
			suma = nota[i] + suma;
		return suma/3;
		}else 
			return suma;
	}

	public static void main(String[] args) {
		double [] nota = {5.5f, -5, 6};
		
		MediaModificado media = new MediaModificado(nota);
		media.avaliable();
		System.out.println(media.media());
	}

}
