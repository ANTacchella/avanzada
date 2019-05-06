package pa.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pa.cola.ColaDinamica;
import pa.cola.ColaVaciaException;

public class ColaDinamicaTest {
	
	ColaDinamica cola;
	
	@Before
	public void setUp() {
		cola = new ColaDinamica();
	}
	
	@Test
	public void testPush() {
		cola.offer(2);
		cola.offer("String");
		assertEquals(2, cola.peek());
	}
	
	@Test
	public void testPop() {
		cola.offer(2);
		cola.offer("String");
		assertEquals(2, cola.poll());
	}
	
	@Test
	public void testPopConColaVacia() {
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
