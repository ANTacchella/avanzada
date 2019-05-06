package pa.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pa.pila.PilaEstatica;
import pa.pila.PilaLlenaException;
import pa.pila.PilaVaciaException;

public class PilaEstaticaTest {
	
	PilaEstatica pila;
	
	@Before
	public void setUp() throws Exception{
		pila = new PilaEstatica(2);
	}
	
	@Test
	public void testPush() throws PilaLlenaException {
		pila.push(2);
		pila.push("String");
		assertEquals("String", pila.peek());
	}
	
	@Test
	public void testPushMasDelTamaño() {
		pila.push(2);
		pila.push("String");
		try {
			pila.push(true);
		}
		catch (PilaLlenaException excp){
			System.out.println(excp);
		}
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
