package practicas.practi01;

public class CProceso {

	private String identificador;
	private String titulo;
	private float arancel;

	public CProceso(String identificador, String titulo, float arancel) {
		super();
		this.identificador = identificador;
		this.titulo = titulo;
		this.arancel = arancel;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getArancel() {
		return arancel;
	}

	public void setArancel(float arancel) {
		this.arancel = arancel;
	}

	public void mostrar() {
		System.out.println(identificador + "\t" + titulo + "\t" + arancel);
	}

}