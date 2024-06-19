package estatisticas;

import java.util.Random;

public class Estatistica {
	
	public static int[] obtenerVotos(int[] votos) {
		Random random = new Random();
		for (int k = 0; k < votos.length; k++)
			votos[k] = Math.abs((byte) random.nextInt() * 20);
		return votos;
	}

	public static void mostrarVotos(int[] votos) {
		for (int k = 0; k < votos.length; k++)
			System.out.println("Distrito " + (k + 1) + ": " + votos[k]);
	}

	public int numeroDistrictos(int[] votos) {
		return votos.length;
	}

	public static int mediaVotos(int[] votos) {
		int media = 0;

		for (int k = 0; k < votos.length; k++)
			media += votos[k];

		return media = (int) media / votos.length;
	}

	public static int maximoVotos(int[] votos) {
		int max = 0;

		for (int k = 0; k < votos.length; k++)
			if (votos[k] > max)
				max = votos[k];
		return max;
	}

	public static int minimoVotos(int[] votos) {
		int min = votos[0];

		for (int k = 1; k < votos.length; k++)
			if (votos[k] < min)
				min = votos[k];
		return min;
	}
}
