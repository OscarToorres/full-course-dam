package misClases.avaliacion1;

public class CSerie {

	private int entero;
	private int i = 0;
	private int numero;

	public void Mostrar1_10() {
		entero = 1;
		for (; i < 10; entero = 1 + entero) {
			System.out.println(entero);
			i++;
		}
	}

	public void Mostrar10_1() {
		entero = 10;
		for (; i < 10; entero = entero - 1) {
			System.out.println(entero);
			i++;
		}
	}

	public void MuestraHasta20(int i) {
		for (; i <= 20; i = 1 + i) {
			System.out.println(i);
		}
	}

	public void MuestraDesde20(int i) {
		numero = 20;
		while (i <= 20) {
			System.out.println(numero);
			i = i + 1;
			numero = numero - 1;
		}
	}

	public void MuestraA_B(int i, int i2) {
		for (; i2 >= i; i++) {
			System.out.println(i);
		}
	}

	public void MuestraB_A(int i, int i2) {
		for (; i <= i2; i2 = i2 - 1) {
			System.out.println(i2);
		}
	}

	public void muestraB_AsumaAimpares(int a, int b) {
		while (a < b) {
			System.out.print(" " + a + "+" + b + " ");
			b--;
			System.out.print(b);
			b--;

		}
		System.out.print(" " + a + "+" + b + " ");
	}

	public void muestraA_BrstaBtres(int a, int b) {
		while (a < b) {
			if (a % 3 == 0) {
				System.out.print(" (" + a + "-" + b + ") ");
			}
			a++;
			System.out.print(a + " ");
		}
	}

	public void muestraA_Bsuma500seis(int a, int b) {
		while (a < b) {
			if (a % 2 == 0) {
				if (a % 6 == 0)
					System.out.print(" " + (a + 500) + " ");
				System.out.print(" " + a + " ");
			}
			a++;
		}
	}

	public void muestraA_Bmulti4partido(int a, int b) {
		while (a <= b) {
			if (a % 4 == 0) {
				System.out.print("(" + (a / 4) + "*" + (a / 2) + ")");
			} else
				System.out.print(" " + a + " ");
			a++;
		}
	}
}