package tarea3_11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculoTest {

	@Test
	void mediaOK() {
		double [] valores = {1, 1, 1, 1};
		double  esperado = (double) (1 + 1 + 1 + 1) / 4;
		Calculo calculo = new Calculo();
		calculo.inserirValores(valores);
		assertEquals(esperado, calculo.media());
	}
	@Test
	void sumarOK() {
		double [] valores = {1, 1, 1, 1};
		double  esperado = (double) 1 + 1 + 1 + 1;
		Calculo calculo = new Calculo();
		calculo.inserirValores(valores);
		assertEquals(esperado, calculo.sumar());
	}
	
	
	
	

}