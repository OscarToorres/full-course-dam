package tarea3_6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TransferenciaTest {

	@Test
	void transferenciaOKTest() {
		Clienta orixe = new Clienta("1A", 100);
        Clienta destino = new Clienta("2B", 200);
		Transferencia transferencia = new Transferencia(orixe, destino);
        double cantidade = 200;
		boolean esperado = false;
	    assertEquals(esperado, transferencia.transferencia(cantidade));
	}
	
	@Test
	void transferenciaNotOKTest() {
		Clienta orixe = new Clienta("1A", 100);
        Clienta destino = new Clienta("2B", 200);
		Transferencia transferencia = new Transferencia(orixe, destino);
        double cantidade = 80;
		boolean esperado = true;
	    assertEquals(esperado, transferencia.transferencia(cantidade));
	}

}
