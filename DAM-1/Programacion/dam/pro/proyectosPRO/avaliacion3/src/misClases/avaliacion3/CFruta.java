package misClases.avaliacion3;

public class CFruta {
	
	private String codigo;
	private String nombre;
	private int cantidad;
	private float precio;
	
	public CFruta(String codigo, String nombre, int cantidad, float precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
        System.out.println(String.valueOf(this.codigo) + "\t\t" + this.nombre + "\t" + this.cantidad + "\t" + this.precio);
    }
}