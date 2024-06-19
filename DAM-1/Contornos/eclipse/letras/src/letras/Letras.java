package letras;

public class Letras {

	private String frase = "";
	private CharSequence letra;
	
	public Letras(String frase, CharSequence letra ) {
		super();
		this.frase = frase;
		this.letra = letra;
	}

	public boolean verificar() {
		boolean verdadeiro = this.frase.contains(this.letra)?true:false;
		return verdadeiro;
	}

	public static void main(String[] args) {
		String frase = "Estamos a luns por iso nos costa tanto traballar";
		CharSequence letra = "a";
		Letras letras = new Letras(frase, letra);
		System.out.println(letras.verificar());
	}

}
