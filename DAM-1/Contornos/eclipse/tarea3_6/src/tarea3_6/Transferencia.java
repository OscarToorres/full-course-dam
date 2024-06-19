package tarea3_6;

public class Transferencia {
	
	private boolean ok = false;
	private static final String OK = "EXITO";
	private static final String NOTOK = "NO REALIZADA";
	private final Clienta orixe;
	private final Clienta destino;

	public Transferencia(Clienta orixe, Clienta destino) {
		this.orixe = orixe;
		this.destino = destino;

	}
	
	public String mensaxeok() {
		if(this.ok)
			return OK;
		else 
			return NOTOK;
	}
	
	public boolean transferencia(double cantidade) {
		if(this.orixe.getSaldo() >= cantidade) {
			this.orixe.setSaldo(this.orixe.getSaldo() - cantidade);
			this.destino.setSaldo(this.destino.getSaldo() + cantidade);
			ok = true;
			return ok;
		} else
			ok = false;
			return ok;
	}
	
}