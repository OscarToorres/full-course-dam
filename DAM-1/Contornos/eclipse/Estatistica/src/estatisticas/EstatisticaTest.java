package estatisticas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EstatisticaTest {

	int[] prueba = new int[] {100 , 200, 300, 400, 500};

	@Test
	void testMedia() {
		int esperado = Estatistica.mediaVotos(prueba);
		int real = (100 + 200 + 300 + 400 + 500) / this.prueba.length;
		assertEquals(esperado, real);
	}
	
	@Test
	void testMaximo() {
		int esperado = 500;
		int real = Estatistica.maximoVotos(prueba);
		assertEquals(esperado, real);
	}
	
	@Test
	void testMinimo() {
		int esperado = 100;
		int real = Estatistica.minimoVotos(prueba);
		assertEquals(esperado, real);
	}
}
