package pa.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pa.cola.ColaEstatica;
import pa.cola.ColaLlenaException;
import pa.cola.ColaVaciaException;

public class ColaEstaticaTest {

	ColaEstatica cola;
	
	@Before
	public void setUp() {
		cola = new ColaEstatica();
	}
	
	@Test
	public void testOffer() throws ColaLlenaException {
		cola.offer(2);
		cola.offer("String");
		assertEquals(2, cola.peek());
	}
	
	@Test
	public void testPoll() {
		cola.offer(2);
		cola.offer("String");
		try {
			assertEquals(2, cola.poll());
		}
		catch (ColaVaciaException excp){
			System.out.println(excp);
		}
		
	}
	
	@Test
	public void testPollConColaVacia() {
		cola.offer(2);
		cola.offer("String");
		try {
			assertEquals(2, cola.poll());
			assertEquals("String", cola.poll());
			cola.poll();
		}
		catch (ColaVaciaException excp){
			System.out.println(excp);
		}
		
	}

	@Test
	public void testPeek() {
		cola.offer(2);
		cola.offer("String");
		assertEquals(2, cola.peek());
	}
	
	@Test
	public void testIsEmpty() {
		cola.offer(2);
		cola.offer("String");
		assertEquals(2, cola.poll());
		assertEquals("String", cola.poll());
		assertTrue(cola.isEmpty());
	}
	
	@Test
	public void testIsEmptyColaConElementos() {
		cola.offer(2);
		cola.offer("String");
		assertEquals(2, cola.poll());
		assertFalse(cola.isEmpty());
	}
}
