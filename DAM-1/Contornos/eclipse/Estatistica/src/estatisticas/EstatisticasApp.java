package estatisticas;

public class EstatisticasApp {
	
	private final static String DISTRICTOS = "Número de distritos: ";
	private final static String MEDIA = "Media dos votos emitidos: ";
	private final static String MAX = "Maximo de los votos emitidos: ";
	private final static String MIN = "Minimo de los votos emitidos: ";

	public static void main(String[] args) {
		
		int[] votos = new int[5];
		
		Estatistica estatistica = new Estatistica();
		
		Estatistica.obtenerVotos(votos);
		Estatistica.mostrarVotos(votos);
		System.out.println(DISTRICTOS + estatistica.numeroDistrictos(votos));
		System.out.println(MEDIA + Estatistica.mediaVotos(votos));
		System.out.println(MAX + Estatistica.maximoVotos(votos));
		System.out.println(MIN + Estatistica.minimoVotos(votos));
	
	}
}





