package misClases.avaliacion2;

public class CMatriz {

	private int[][] matriz;

	public CMatriz() {
		this.matriz = new int[2][3];
	}

	public void inicializa() {
		this.matriz[0][0] = 6;
		this.matriz[0][1] = 9;
		this.matriz[0][2] = 8;
		this.matriz[1][0] = 4;
		this.matriz[1][1] = 7;
		this.matriz[1][2] = 3;
	}

	public void amosaPorFilas() {
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < 3; ++j) {
				System.out.print("   " + this.matriz[i][j] + "   ");
			}
			System.out.println("");
		}
	}

	public void amosaPorColumnas() {
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 2; i++) {
				System.out.print("   " + this.matriz[i][j] + "   ");
			}
			System.out.println("");
		}
	}

	public void amosaPorFilasTotal() {
		for (int i = 0; i < this.matriz.length; ++i) {
			int total = 0;
			for (int j = 0; j < this.matriz[i].length; ++j) {
				System.out.print("   " + this.matriz[i][j] + "   ");
				total += this.matriz[i][j];
			}
			System.out.println("(total: " + total + ")");
		}
	}

	public void amosaPorColumnasTotal() {
		for (int j = 0; j < this.matriz[0].length; j++) {
			int total = 0;
			for (int i = 0; i < this.matriz.length; i++) {
				System.out.print("   " + this.matriz[i][j] + "   ");
				total = total + this.matriz[i][j];
			}
			System.out.println("(Total: " + total + ")");
		}
	}

	public void oMaior() {
		int maior = this.matriz[0][0];
		for (int i = 0; i < this.matriz.length; i++) {
			for (int j = 0; j < this.matriz.length; j++) {
				if (maior < this.matriz[i][j])
					maior = this.matriz[i][j];
			}
		}
		System.out.println("O maior da matriz: " + maior);
	}

	public void amosaFilaMaior() {
		int totalFila = 0;
		int maiorFila = 0;
		for (int i = 0; i < this.matriz.length; i++) {
			int total = 0;
			for (int j = 0; j < this.matriz.length; j++) {
				total = total + this.matriz[i][j];
			}
			if (total > totalFila) {
				totalFila = total;
				maiorFila = i;
			}
		}
		System.out.println("    Fila Maior");
		System.out.println("    ==========");
		for (int j = 0; j < this.matriz[0].length; j++)
			System.out.print("   " + this.matriz[maiorFila][j] + "   ");
	}

	public void amosaColumnaMaior() {
		int totalColumna = 0;
		int maiorColumna = 0;
		for (int j = 0; j < this.matriz[0].length; j++) {
			int total = 0;
			for (int i = 0; i < this.matriz.length; i++) {
				total = total + this.matriz[i][j];
			}
			if (total > totalColumna) {
				totalColumna = total;
				maiorColumna = j;
			}
		}
		System.out.println("    Columna Maior");
		System.out.println("    ==========");
		for (int i = 0; i < this.matriz.length; i++)
			System.out.println("         " + this.matriz[i][maiorColumna]);

	}

}
