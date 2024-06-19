package numerospares;

public class VerificarNumeros {

	private int numero;

	public VerificarNumeros(int numero) {
		super();
		this.numero = numero;
	}

	public boolean ePar() {
		return (this.numero % 2 == 0) ? true : false;
	}

	public static void main(String[] args) {

		int n = 45;
		boolean  resultado = true;
		VerificarNumeros numero = new VerificarNumeros(n);
		System.out.println(n + " e par");
		if (numero.ePar()==resultado)
			System.out.println("Par");
		else
			System.out.println("Impar");
		
	}

}
