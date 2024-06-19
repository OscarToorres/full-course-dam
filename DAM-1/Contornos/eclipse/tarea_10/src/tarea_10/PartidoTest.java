package tarea_10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PartidoTest {

	@Test
	void testSumaEquipo() {
		Xogadora x11 = new Xogadora("A11",10);
		Xogadora x12 = new Xogadora("A12",5);
		Xogadora[] xogadoras1 = new Xogadora[] {x11, x12};
		Equipo equipo1 = new Equipo(xogadoras1, 1);
				
		Xogadora x21 = new Xogadora("B21",8);
		Xogadora x22 = new Xogadora("B22",3);
		Xogadora[] xogadoras2 = new Xogadora[] {x21, x22};
		Equipo equipo2 = new Equipo(xogadoras2, 1);
		
		Partido partido = new Partido(equipo1, equipo2);
		int numGanhador = partido.verificarGañador();
		int esperado = 1;
		assertEquals(esperado, numGanhador);
	
	}

}
