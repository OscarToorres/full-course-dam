package exame;

public class CPaciente {
	private String codigo;
	private String nombre;
	private int habitacion;
	private float temperatura;

	public CPaciente(String cod, String nom, int hab, float tem) {
		codigo = cod;
		nombre = nom;
		habitacion = hab;
		temperatura = tem;
	}

	public void setCodigo(String cod) {
		codigo = cod;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setNombre(String nom) {
		nombre = nom;
	}

	public String getNombre() {
		return nombre;
	}

	public void setHabitacion(int hab) {
		habitacion = hab;
	}

	public int getHabitacion() {
		return habitacion;
	}

	public void setTemperatura(float tem) {
		temperatura = tem;
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void mostrar() {
		System.out.print(codigo + "\t" + nombre + "\t\t");
		System.out.println(habitacion + "\t\t" + temperatura);
	}
}