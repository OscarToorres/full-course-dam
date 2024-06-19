package ejercicio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConverterTest {
	
	final double valorRublo = 0.0095;
	final double valorEuro = 113.9670;
	final double cantidade = 100;

	@Test
	void convertOK1() {
		int opcion = 0;
		Unit unit = new Unit(valorRublo, valorEuro, cantidade);
		Converter converter = new Converter(unit, opcion);
		double esperado = cantidade * valorEuro;
		assertEquals(esperado, converter.convert());
	}
	
	@Test
	void convertOK2() {
		int opcion = 1;
		Unit unit = new Unit(valorRublo, valorEuro, cantidade);
		Converter converter = new Converter(unit, opcion);
		double esperado = cantidade * valorRublo;
		assertEquals(esperado, converter.convert());
	}
	
	@Test
	void converterNotOK() {
		int opcion = 3;
		Unit unit = new Unit(valorRublo, valorEuro, cantidade);
		Converter converter = new Converter(unit, opcion);
		double esperado = 0;
		assertEquals(esperado, converter.convert());
	}

}
