package misClases.avaliacion1;

public class CNotas {

	private float[] notas = { 3.2F, 7.45F, 8.15F, 5.6F, 5.35F, 9.15F, 2.45F, 4.4F, 6.7F, 1.8F };

	public void mostraNotas() {
		int i;

		System.out.println("Relacion de NOTAS");
		System.out.println("=================");
		for (i = 0; i < 10; i++)
			System.out.println("Alumno " + (i + 1) + ": " + notas[i]);
	}

	public float dameNota(int i) {
		return notas[i];
	}

	public void mostrarAprobados() {
		int i;

		System.out.println("Relacion de APROBADOS");
		System.out.println("=====================");
		for (i = 0; i < 10; i++) {
			if (notas[i] >= 5)
				System.out.println("Alumno " + (i + 1) + ": " + notas[i]);
		}
	}

	public void mostrarSuspensos() {
		int i;

		System.out.println("Relacion de SUSPENSOS");
		System.out.println("=====================");
		for (i = 0; i < 10; i++) {
			if (notas[i] < 5)
				System.out.println("Alumno " + (i + 1) + ": " + notas[i]);
		}
	}

	public int dameMayor() {
		int i;
		int indiceMayor = 0;
		float notaMayor = 0;

		for (i = 0; i < 10; i++) {
			if (notas[i] > notaMayor) {
				notaMayor = notas[i];
				indiceMayor = i;
			}
		}
		return indiceMayor;
	}

	public int dameMenor() {
		int i = 0;
		int indiceMenor = 0;
		float notaMenor = 10;

		for (i = 0; i < 10; i++) {
			if (notas[i] < notaMenor) {
				indiceMenor = i;
			}
		}
		return indiceMenor;
	}

	public float dameMedia() {
		int i = 0;
		float media = 0;
		
		for (i = 0; i < 10; i++) 
			media = media + notas[i];
		
		media = media / i;
		return media;
	}
	
}