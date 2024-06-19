package preparatorios.ejem01;

public class CLibro {
	private int codigo;
	private String titulo;
	private float precio;

	public CLibro(int cod, String tit, float pre) {
		codigo = cod;
		titulo = tit;
		precio = pre;
	}

	public void setCodigo(int cod) {
		codigo = cod;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setTitulo(String tit) {
		titulo = tit;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setPrecio(float pre) {
		precio = pre;
	}

	public float getPrecio() {
		return precio;
	}

	public void mostrar() {
		System.out.println(codigo + "\t" + titulo + "\t" + precio);
	}

}