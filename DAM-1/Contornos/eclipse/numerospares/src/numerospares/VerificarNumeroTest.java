package numerospares;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VerificarNumeroTest {

	@Test
	void testEPar() {
		
		int n = 200;
		VerificarNumeros verifficarNumero = new VerificarNumeros(n);
		boolean esperado = true;
		assertEquals(esperado, verifficarNumero.ePar());
	
	}

}
