package ecuacionRecta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectaTest {

	int a1 = 1;
	int a2 = 2;
	int b1 = 1;
	int b2 = 2;
	int x0 = 4;
	int m = 6;

	@Test
	public void pendienteTest() {
		Recta recta = new Recta();
		int actual = recta.pendiente(a1, a2, b1, b2);
		int esperado = (1 - 2) / (1 - 2);
		assertEquals(esperado, actual);
	}

	@Test
	public void calculoOrdendaTest() {
		Recta recta = new Recta();
		int actual = recta.calculoOrdenda(b2, x0, a2, m);
		int esperado = 2 + 6 * (4 - 2);
		assertEquals(esperado, actual);
	}
}
