package tarea3_12;

public class Enerxia {
	
	private static double GRAVIDADE = 9.81;
	private double ePotencial = 0.0;
	private double eCinetica = 0.0;
	private double velocidade = 0.0;
	private double masa = 0.0;
	
	public Enerxia (double masa) {
		this.masa = masa;
	}
	
	public double ePotencial(double altura) {
		double temp = masa * altura * GRAVIDADE;
		return this.ePotencial;
	}
	
	public double eCinetica(double velocidade) {
		double temp = masa * Math.pow(velocidade, 2.0) * 0.5;
		return this.eCinetica;
	}
	
	public double calculaVelocidade () {
		double temp = this.eCinetica * 2.0 / this.masa;
		this.velocidade = Math.sqrt(this.velocidade);
		return this.velocidade;
	}
	
}
