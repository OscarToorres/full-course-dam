package tarea3_5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AvaliacionTestA {

	
	public void cualificacionFinalTestOK() {
		int[] cualificacions = new int[] { 6, 5, 3, 7, 6};
		double esperado = (double) (6 + 5 + 3 + 7 + 6) / 5;
		Alumna alumna = new Alumna("Manuel", "DAM", "CD", 1, cualificacions);
		Avaliacion avaliacion = new Avaliacion(alumna);
		double real = avaliacion.cualificacionFinal();
		assertEquals(esperado, real);

	}
	@Test
	public void cualificacionFinalTestNoOK() {
		int[] cualificacions = new int[] { 6, 5, -3, 7, 6 };
		double esperado = 0.0;
		Alumna alumna = new Alumna("Manuel", "DAM", "CD", 1, cualificacions);
		Avaliacion avaliacion = new Avaliacion(alumna);
		double real = avaliacion.cualificacionFinal();
		assertEquals(esperado, real);

	}
	
	public void validacion() {
		int[] cualificacions = new int[] { 6, 5, 3, 7, 6 };
		Alumna alumna = new Alumna("Manuel", "DAM", "CD", 1, cualificacions);
		Avaliacion avaliacion = new Avaliacion(alumna);
		boolean esperado = false;
		boolean real = avaliacion.validacion();
		assertEquals(esperado, real);

	}
}
