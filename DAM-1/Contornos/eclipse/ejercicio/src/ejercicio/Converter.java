package ejercicio;

public class Converter {

	private double valorRublo;
	private double valorEuro;
	private double cantidade;
	private double resultado;

	// opción 0, realizar conversión de rublos a euros
	// opción 1, realizar conversión de euros a rublos
	private int opcion;

	public Converter(Unit unit, int opcion) {
		super();
		this.valorRublo = unit.getRublo();
		this.valorEuro = unit.getEuro();
		this.cantidade = unit.getCantidade();
		this.opcion = opcion;
		this.resultado = this.convert();
	}

	public double convert() {
		//consideramos que el 0 es un numero que nos indica un error en la introcuccion de la opcion, 
		//es decir un numero distinto de 1 o 2, que son las opciones implementadas.
		int error = 0;
		
		if (this.opcion == 0) {
			this.resultado = this.cantidade * this.valorEuro;
			return this.resultado;
		} else if(this.opcion == 1) {
			this.resultado = this.cantidade * this.valorRublo;
			return this.resultado;
		}else
			return error;

	}

}