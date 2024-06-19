package basico;

public class Cualificacion {

	private double c1;
	private double c2;
	private double t;

	public Cualificacion(double c1, double c2, double t) {
		super();
		this.c1 = c1;
		this.c2 = c2;
		this.t = t;
	}

	public double getC1() {
		return c1;
	}

	public void setC1(double c1) {
		this.c1 = c1;
	}

	public double getC2() {
		return c2;
	}

	public void setC2(double c2) {
		this.c2 = c2;
	}

	public double getT() {
		return t;
	}

	public void setT(double t) {
		this.t = t;
	}

	public double global() {

		double nota;
		if (this.t >= 5.0 && this.c1 >= 5 && this.c2 >= 5) {
			nota = 0.4 * ((this.c1 + this.c2) / 2) + 0.6 * this.t;
		} else if (this.c1 >= 5 && this.c2 >= 5){
			nota =  0.4 * ((this.c1 + this.c2) / 2);
		} else if (this.c1 < this.c2) {
			nota = this.c2;
		}else {
			nota = this.c1;
		}
		return nota;
		}

	public String toString() {
		return "Cualificacion [c1=" + c1 + ", c2=" + c2 + ", t=" + t + "]";
	}
	
}
