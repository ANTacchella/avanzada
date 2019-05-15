package pa.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pa.lista.ListaSimplementeEnlazada;

public class ListaSimplementeEnlazadaTest {
	
	ListaSimplementeEnlazada lista;
	
	@Before
	public void setUp() throws Exception {
		lista = new ListaSimplementeEnlazada();
	}

	@Test
	public void testPushBack() {
		lista.pushBack(4);
		lista.pushBack(5);
		assertEquals(4, lista.getPrimerNodo().getDatos());
		assertEquals(5, lista.getUltimoNodo().getDatos());
	}
	
	@Test
	public void testPopBack() {
		lista.pushBack(4);
		lista.pushBack(5);
		lista.popBack();
		assertEquals(4, lista.getUltimoNodo().getDatos());		
	}
	
	@Test
	public void testPushFront() {
		lista.pushFront(4);
		lista.pushFront(5);
		assertEquals(5, lista.getPrimerNodo().getDatos());
		assertEquals(4, lista.getUltimoNodo().getDatos());		
	}
	
	@Test
	public void testPopFront() {
		lista.pushBack(4);
		lista.pushBack(5);
		lista.popFront();
		assertEquals(5, lista.getUltimoNodo().getDatos());		
	}
	
	@Test
	public void testRemovePrimerNodo() {
		lista.pushBack(4);
		lista.pushBack(5);
		lista.pushBack(6);
		lista.pushBack(8);
		lista.remove(4);
		assertEquals(5, lista.getPrimerNodo().getDatos());
	}
	
	@Test
	public void testRemoveUltimoNodo() {
		lista.pushBack(4);
		lista.pushBack(5);
		lista.pushBack(6);
		lista.pushBack(8);
		lista.remove(8);
		assertEquals(6, lista.getUltimoNodo().getDatos());
	}
	
	@Test
	public void testRemove() {
		lista.pushBack(4);
		lista.pushBack(5);
		lista.pushBack(6);
		lista.pushBack(8);
		lista.remove(5);
		assertFalse(lista.search(5));
	}
	
	@Test
	public void testReverseCorrecto() {
		lista.pushBack(4);
		lista.pushBack(5);
		lista.pushBack(6);
		lista.pushBack(8);
		lista.reverse();
		assertEquals(8, lista.getPrimerNodo().getDatos());
		assertEquals(6, lista.getPrimerNodo().getNodoSiguiente().getDatos());
		assertEquals(4, lista.getUltimoNodo().getDatos());
	}
	
	@Test
	public void testInsertAtFinal() {
		lista.pushBack(4);
		lista.pushBack(5);
		lista.pushBack(6);
		lista.insertAt(2, 8);
		assertEquals(6, lista.getUltimoNodo().getDatos());
		assertTrue(lista.search(8));
	}
	
	@Test
	public void testInsertAt1MasFinal() {
		lista.pushBack(4);
		lista.pushBack(5);
		lista.pushBack(6);
		lista.insertAt(3, 8);
		assertEquals(8, lista.getUltimoNodo().getDatos());
	}
	
	@Test
	public void testInsertAtPrincipio() {
		lista.pushBack(4);
		lista.pushBack(5);
		lista.pushBack(6);
		lista.insertAt(0, 8);
		assertEquals(8, lista.getPrimerNodo().getDatos());
	}
	
	@Test
	public void testEraseAtUltimoNodo() {
		lista.pushBack(4);
		lista.pushBack(5);
		lista.pushBack(6);
		lista.eraseAt(2);
		assertEquals(5, lista.getUltimoNodo().getDatos());
	}
	
	@Test
	public void testEraseAtPrimerNodo() {
		lista.pushBack(4);
		lista.pushBack(5);
		lista.pushBack(6);
		lista.eraseAt(0);
		assertEquals(5, lista.getPrimerNodo().getDatos());
	}
	
	@Test
	public void testEraseAtMedio() {
		lista.pushBack(4);
		lista.pushBack(5);
		lista.pushBack(6);
		lista.eraseAt(1);
		assertFalse(lista.search(5));
	}
	
	@Test
	public void testIsEmpty() {
		assertEquals(true, lista.isEmpty());
	}
	
	@Test
	public void testSearch() {
		lista.pushBack(4);
		lista.pushBack(5);
		lista.pushBack(6);
		lista.pushBack(8);
		assertTrue(lista.search(6));
	}
	
	@Test
	public void testSearchAt0() {
		lista.pushBack(4);
		lista.pushBack(5);
		lista.pushBack(6);
		lista.pushBack(8);
		assertEquals(4,lista.searchAt(0));
	}
	
	@Test
	public void testSearchAt2() {
		lista.pushBack(4);
		lista.pushBack(5);
		lista.pushBack(6);
		lista.pushBack(8);
		assertEquals(6,lista.searchAt(2));
	}
	
	@Test
	public void testSearchAt3() {
		lista.pushBack(4);
		lista.pushBack(5);
		lista.pushBack(6);
		lista.pushBack(8);
		assertEquals(8,lista.searchAt(3));
	}
	
	@Test
	public void testSizeMayor1() {
		lista.pushBack(4);
		lista.pushBack(5);
		lista.pushBack(6);
		lista.pushBack(8);
		assertEquals(4, lista.size());
	}
	
	@Test
	public void testSize1() {
		lista.pushBack(4);
		assertEquals(1, lista.size());
	}

}
