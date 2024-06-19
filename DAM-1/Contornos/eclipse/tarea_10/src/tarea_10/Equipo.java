package tarea_10;

public class Equipo {
	
	private static final int XOGADORAS = 2;
	private Xogadora[] xogadoras = new Xogadora[XOGADORAS];
	private int xornada;
	
	public Equipo(Xogadora[] xogadoras, int xornada) {
		super();
		this.xogadoras = xogadoras;
		this.xornada = xornada;
	}

	public Xogadora[] getXogadoras() {
		return xogadoras;
	}
	
	

}
