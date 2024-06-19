package tarea_10;

public class Partido {

	private Equipo equipo1;
	private Equipo equipo2;
	
	private int suma1, suma2;
	private int ganhador;
	
	public Partido(Equipo equipo1, Equipo equipo2) {
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}
	
	private int sumaEquipo1() {
		Xogadora[] xogadoras = this.equipo1.getXogadoras();
		for (int k = 0; k < this.equipo1.getXogadoras().length; k++)
			this.suma1 += xogadoras[k].getPuntos();
		return this.suma1;
	}
	
	private int sumaEquipo2() {
		Xogadora[] xogadoras = this.equipo2.getXogadoras();
		for (int k = 0; k < this.equipo2.getXogadoras().length; k++)
			this.suma2 += xogadoras[k].getPuntos();
		return this.suma2;
	}
	
	public int verificarGañador() {
		this.suma1 = sumaEquipo1();
		this.suma2 = sumaEquipo2();
		int ganhador = (this.suma1 > this.suma2)?1:2;
		return ganhador;
	}
	
	
	
}
