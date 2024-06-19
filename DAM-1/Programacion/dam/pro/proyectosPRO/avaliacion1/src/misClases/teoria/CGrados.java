package misClases.teoria;

public class CGrados {

	private float gradosC;
	
	public void CentigradosAsignar(float gC) {
		gradosC = gC;
	}
	
	public float FahrenheitObtener() {
		return 9F/5F * gradosC + 32;
	}
	
	public float CentigradosObtener() {
		return gradosC;
	}
}
