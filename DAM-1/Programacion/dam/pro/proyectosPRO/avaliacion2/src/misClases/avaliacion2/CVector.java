package misClases.avaliacion2;

public class CVector {

	private int vector[] = new int[20];
	private int total = 0;

	public void menu() {
		System.out.println();
		System.out.println("MENU");
		System.out.println("======");
		System.out.println("1.- INICIALIZA Vector de enteiros");
		System.out.println("2.- AMOSA Vector");
		System.out.println("3.- INSERTA enteiro en Vector");
		System.out.println("4.- ELIMINA enteiro en Vector");
		System.out.println("5.- FINAL");
		System.out.println();
	}
	
	public void IniciarVectorEnteros() {
		vector[0] = 3;
		vector[1] = 12;
		vector[2] = 15;
		vector[3] = 22;
		vector[4] = 30;
		vector[5] = 43;
		System.out.println("Vector INICIALIZADO");
	}


	public void mostrarVectores() {
		System.out.println("   VECTOR de Enteiros");
		System.out.println("   ==================");
		total = 0;
		for (int i = 0; i < this.vector.length; i++) {
			if (vector[i] != '\0') {
			System.out.println("     " + vector[i]);
			total++;
			}
		}
		System.out.println("    TOTAL = " + total);
	}

	public void insertaVector(final int numero) {
        int i;
        for (i = 0; this.vector[i] < numero && i < this.total; ++i) {}
        for (int j = this.total; j > i; --j) {
            this.vector[j] = this.vector[j - 1];
        }
        this.vector[i] = numero;
        ++this.total;
    }
	
	public void eliminaVector(final int numero) {
        int i;
        for (i = 0; this.vector[i] != numero && i < this.total; ++i) {}
        for (int j = i; j < this.total; ++j) {
            this.vector[j] = this.vector[j + 1];
        }
        if (i < this.total) {
            --this.total;
        }
	}
}

	
	
	
	
	