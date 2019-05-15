package pa.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pa.pila.PilaDinamica;
import pa.pila.PilaVaciaException;

public class PilaDinamicaTest {
	
	PilaDinamica pila;
	
	@Before
	public void setUp() {
		pila = new PilaDinamica();
	}
	
	@Test
	public void testPush() {
		pila.push(2);
		pila.push("String");
		assertEquals("String", pila.peek());
	}
	
	@Test
	public void testPop() {
		pila.push(2);
		pila.push("String");
		assertEquals("String", pila.pop());
	}
	
	@Test
	public void testPopConPilaVacia() {
		pila.push(2);
		pila.push("String");
		try {
			assertEquals("String", pila.pop());
			assertEquals(2, pila.pop());
			pila.pop();
		}
		catch (PilaVaciaException excp){
			System.out.println(excp);
		}
		
	}

	@Test
	public void testPeek() {
		pila.push(2);
		pila.push("String");
		assertEquals("String", pila.peek());
	}
	
	@Test
	public void testIsEmpty() {
		pila.push(2);
		pila.push("String");
		assertEquals("String", pila.pop());
		assertEquals(2, pila.pop());
		assertTrue(pila.isEmpty());
	}
	
	@Test
	public void testIsEmptyPilaConElementos() {
		pila.push(2);
		pila.push("String");
		assertEquals("String", pila.pop());
		assertFalse(pila.isEmpty());
	}	

}

