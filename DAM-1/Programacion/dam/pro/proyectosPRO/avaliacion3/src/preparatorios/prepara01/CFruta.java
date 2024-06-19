package preparatorios.prepara01;

public class CFruta {

	private String codigo;
	private String nome;
	private int cantidad;
	private float precio;

	public CFruta(String codigo, String nome, int cantidad, float precio) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void mostrar() {
		System.out.println(codigo + "\t" + nome + "\t" + cantidad + "\t" + precio);
	}
	
}
