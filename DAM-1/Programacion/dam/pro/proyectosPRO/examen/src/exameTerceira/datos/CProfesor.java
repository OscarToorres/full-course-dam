package exameTerceira.datos;

public class CProfesor {

	private String codigo;
	private String nombre;
	private String aula;
	private float baremo;
	
	public CProfesor(String codigo, String nombre, String aula, float baremo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.aula = aula;
		this.baremo = baremo;
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

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public float getBaremo() {
		return baremo;
	}

	public void setBaremo(float baremo) {
		this.baremo = baremo;
	}

    public void mostrar() {
        System.out.print(String.valueOf(this.codigo) + "\t\t" + this.nombre + "\t");
        System.out.println(String.valueOf(this.aula) + "\t\t" + this.baremo);
    }
	
	
	
	
	
}
