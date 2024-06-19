package misClases.avaliacion2;

import java.io.IOException;

public class CCadena {

	private char[] cadena = new char[30];

	public void recolleCadena() throws IOException {
		char letra = (char) System.in.read();
		for (int i = 0; letra != '\r'; letra = (char) System.in.read(), i++)
			this.cadena[i] = letra;
	}

	public void amosaCadena() {
		for (int i = 0; i < 30; i++)
			System.out.print(cadena[i]);
	}

	public void amosaRevesCadena() {
		int i;
		for (i = 0; this.cadena[i] != '\0'; ++i) {
		}
		--i;
		while (i >= 0) {
			System.out.print(this.cadena[i]);
			--i;
		}
	}

	public void invierteCadena() {
		int i;
		for (i = 0; this.cadena[i] != '\0'; ++i) {
		}
		--i;
		for (int j = 0; j < i; ++j, --i) {
			char letra = this.cadena[j];
			this.cadena[j] = this.cadena[i];
			this.cadena[i] = letra;
		}
	}

	public void capicua() {
		int i;
		for (i = 0; this.cadena[i] != '\0'; ++i) {
		}
		int j = i;
		--i;
		while (i >= 0) {
			this.cadena[j] = this.cadena[i];
			++j;
			--i;
		}
	}

	public void eliminaEnCadena(char letra) {
		int i;
		int j = i = 0;
		while (this.cadena[i] != '\0') {
			if (this.cadena[i] == letra) {
				++i;
			} else {
				if (i > j) {
					this.cadena[j] = this.cadena[i];
				}
				++i;
				++j;
			}
		}
		while (j <= i) {
			this.cadena[j] = '\0';
			++j;
		}
	}

	public void repiteUnha() {
		for (int i = 0; cadena[i] != '\0'; i++) {
			if (this.cadena[i] == ' ')
				System.out.print(cadena[i]);
			else {
				System.out.print(cadena[i]);
				System.out.print(cadena[i]);
			}
		}
	}

	public void eliminaPares() {
		int i = 0;

		while (cadena[i] != '\0') {
			if (i % 2 != 0)
				System.out.print(cadena[i]);
			i++;
		}
	}

	public void elimina125EnCadena() {
		int i = 0;
		int conta = 0;

		while (cadena[i] != '\0') {
			if (i != 1 && i != 2 && i != 5)
				i++;
			else {
				cadena[conta] = cadena[i];
				conta++;
				i++;
			}
		}
	}

	public void duplica125EnCadena() {
		int k = 0;
		int i = 0;
		while (cadena[i] != '\0') {
			if (i == 1 || i == 2 || i == 5)
				k++;
			i++;
			k++;
		}

		i--;
		k--;

		while (i >= 0) {
			cadena[k] = cadena[i];
			if (i == 1 || i == 2 || i == 5) {
				k--;
				cadena[k] = cadena[i];
			}
			k--;
			i--;
		}
	}

	public void duplicaNumerosEnCadena() {
		int i = 0, k = 0;

		while (cadena[i] != '\0') {
			if (cadena[i] >= '0' && cadena[i] <= '9')
				k++;
			k++;
			i++;
		}

		k--;
		i--;

		while (i >= 0) {
			cadena[k] = cadena[i];
			if (cadena[i] >= '0' && cadena[i] <= '9') {
				k--;
				cadena[k] = cadena[i];
			}
			k--;
			i--;
		}
	}

	public void eliminaVocalesEnCadena() {
		int i = 0;
		int j = 0;

		while (this.cadena[i] != '\0') {
			if (this.cadena[i] == 'a' || this.cadena[i] == 'e' || this.cadena[i] == 'i' 
					|| this.cadena[i] == 'o' || this.cadena[i] == 'u') {
				i++;
			}
			this.cadena[j] = this.cadena[i];
			i++;
			j++;
		}
		while (this.cadena[j] != '\0') {
			this.cadena[j] = '\0';
			j++;
		}
	}
	


}