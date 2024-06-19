package base;

public class Positivo {

	private int numero;
	Positivo(int n){
		this.numero = n;
	}

	public boolean ePositivo() {
		boolean ok = (this.numero >= 0)?true:false;
		return ok;
	}
	public static void main(String[] args) {

		Positivo positivo = new Positivo(120);
		System.out.println(positivo.ePositivo());
	}

}
