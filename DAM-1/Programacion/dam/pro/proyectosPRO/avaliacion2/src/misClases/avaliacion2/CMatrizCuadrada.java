package misClases.avaliacion2;

public class CMatrizCuadrada {

	private int[][] matriz = new int[3][3];
	private int[][] matrizA = new int[3][3];
	private int[][] matrizB = new int[3][3];
	private static final int MAX = 3;

	public void inicializaMatrizA() {
		matrizA[0][0] = 1;
		matrizA[0][1] = 2;
		matrizA[0][2] = 3;
		matrizA[1][0] = 4;
		matrizA[1][1] = 5;
		matrizA[1][2] = 6;
		matrizA[2][0] = 7;
		matrizA[2][1] = 8;
		matrizA[2][2] = 9;
	}

	public void inicializa() {
		matriz[0][0] = 1;
		matriz[0][1] = 2;
		matriz[0][2] = 3;
		matriz[1][0] = 4;
		matriz[1][1] = 5;
		matriz[1][2] = 6;
		matriz[2][0] = 7;
		matriz[2][1] = 8;
		matriz[2][2] = 9;
	}

	public void amosaDereitaAbaixo() {

		for (int j = 0; j < this.matriz[0].length; j++) {
			for (int i = 0; i < this.matriz.length; i++)
				System.out.print("  " + matriz[i][2 - j]);
			System.out.println();
		}
	}

	public void amosaDereitaArriba() {

		for (int i = 0; i < this.matriz[0].length; i++) {
			for (int j = 0; j < this.matriz.length; j++)
				System.out.print("  " + matriz[2 - i][j]);
			System.out.println();
		}
	}

	public void amosaEsquerdaAbaixo() {

		for (int i = 0; i < this.matriz[0].length; i++) {
			for (int j = 0; j < this.matriz.length; j++)
				System.out.print("  " + matriz[2 - j][2 - i]);
			System.out.println();
		}
	}

	public void amosaEsquerdaAriba() {

		for (int i = 0; i < this.matriz[0].length; i++) {
			for (int j = 0; j < this.matriz.length; j++)
				System.out.print("  " + matriz[2 - i][2 - j]);
			System.out.println();
		}
	}

	public void amosaArribaDereita() {

		for (int i = 0; i < this.matriz[0].length; i++) {
			for (int j = 0; j < this.matriz.length; j++)
				System.out.print("  " + matriz[j][2 - i]);
			System.out.println();
		}
	}

	public void amosaArribaEsquerda() {

		for (int i = 0; i < this.matriz[0].length; i++) {
			for (int j = 0; j < this.matriz.length; j++)
				System.out.print("  " + matriz[2 - j][2 - i]);
			System.out.println();
		}
	}

	public void amosaAbaixoDereita() {

		for (int i = 0; i < this.matriz[0].length; i++) {
			for (int j = 0; j < this.matriz.length; j++)
				System.out.print("  " + matriz[j][i]);
			System.out.println();
		}
	}

	public void amosaAbaixoEsquerda() {

		for (int i = 0; i < this.matriz[0].length; i++) {
			for (int j = 0; j < this.matriz.length; j++)
				System.out.print("  " + matriz[2 - j][i]);
			System.out.println();
		}
	}

	public void copiaAenBcolumna1Repe() {
		for (int i = 0; i < this.matrizA.length; i++) {
			for (int j = 0; j < this.matrizA.length; j++)
				System.out.print("  " + matrizA[i][j]);
			System.out.println();
		}

		System.out.println();

		for (int i = 0; i < this.matrizA.length; i++) {
			for (int j = 0; j < this.matrizA.length; j++) {
				matrizB[i][j] = this.matrizA[j][i];
				System.out.print("  " + matrizB[i][j]);
			}
			System.out.println();
		}
	}

	// El modulo (%) da el resto de una division
	public void copiaAenBfila2Repe() {
		for (int i = 0; i < this.matrizA.length; i++) {
			for (int j = 0; j < this.matrizA.length; j++)
				System.out.print("  " + matrizA[i][j]);
			System.out.println();
		}

		System.out.println();

		for (int i = 0; i < this.matrizA.length; i++) {
			for (int j = 0; j < this.matrizA.length; j++) {
				matrizB[i][j] = this.matrizA[1 - (j / 2)][2 - i];
				System.out.print("  " + matrizB[i][j]);
			}
			System.out.println();
		}
	}

	public void copiaAenBfila3Repe() {
		for (int i = 0; i < this.matrizA.length; i++) {
			for (int j = 0; j < this.matrizA.length; j++)
				System.out.print("  " + matrizA[i][j]);
			System.out.println();
		}

		System.out.println();

		for (int i = 0; i < this.matrizA.length; i++) {
			for (int j = 0; j < this.matrizA.length; j++) {
				matrizB[i][j] = this.matrizA[2 - (2 - j) / 2][2 - i];
				System.out.print("  " + matrizB[i][j]);
			}
			System.out.println();
		}
	}

	public void amosaA() {
		System.out.println("");
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++)
				if (this.matrizA[i][j] < 0 || this.matrizA[i][j] > 9) {
					System.out.print("  " + matrizA[i][j]);
				} else {
					System.out.print("  " + matrizA[i][j]);
				}

			System.out.println();
		}
	}

	public void amosaB() {
		System.out.println("");
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++)
				if (this.matrizB[i][j] < 0 || this.matrizB[i][j] > 9) {
					System.out.print("  " + matrizB[i][j]);
				} else {
					System.out.print("  " + matrizB[i][j]);
				}

			System.out.println();
		}
	}

	public void copiaAenB() {
		for (int i = 0; i < this.matrizA.length; i++) {
			for (int j = 0; j < this.matrizA.length; j++) {
				this.matrizB[i][j] = this.matrizA[2-((2-j)/2)][2-i];
			}
		}
	}
}
