package pa.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pa.monticulo.Monticulo;

public class MonticuloTest {
	Monticulo monticulo;
	
	@Before
	public void setUp() {
		monticulo = new Monticulo();
	}
	
	@Test
	public void testInsertar() {
		monticulo.insertar(-5);
		monticulo.insertar(0);
		monticulo.insertar(1);
		monticulo.insertar(3);
		monticulo.insertar(2);
		monticulo.insertar(4);
		monticulo.insertar(3);
		monticulo.insertar(7);
		System.out.println("TestInsertar: ");
		monticulo.imprimir();
	}
	
	@Test
	public void testInsertarNumeroMenorARaiz() {
		monticulo.insertar(-5);
		monticulo.insertar(0);
		monticulo.insertar(1);
		monticulo.insertar(3);
		monticulo.insertar(2);
		monticulo.insertar(4);
		monticulo.insertar(3);
		monticulo.insertar(-6);
		System.out.println("TestInsertarNumeroMenorARaiz: ");
		monticulo.imprimir();
	}
	
	@Test
	public void testQuitarRaizArbolCompleto() {
		monticulo.insertar(-5);
		monticulo.insertar(0);
		monticulo.insertar(1);
		monticulo.insertar(3);
		monticulo.insertar(2);
		monticulo.insertar(4);
		monticulo.insertar(3);
		int valor = monticulo.quitar();
		assertEquals(-5, valor);
		System.out.println("TestQuitarRaizArbolCompleto: ");
		monticulo.imprimir();
	}
	
	@Test
	public void testQuitarRaizArbolIncompleto() {
		monticulo.insertar(-5);
		monticulo.insertar(0);
		monticulo.insertar(1);
		monticulo.insertar(-3);
		monticulo.insertar(2);
		monticulo.insertar(4);
		monticulo.insertar(3);
		monticulo.insertar(7);
		int valor = monticulo.quitar();
		assertEquals(-5, valor);
		System.out.println("TestQuitarRaizArbolIncompleto: ");
		monticulo.imprimir();
	}

}
