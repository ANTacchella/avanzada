package pa.graphTraversalAlgorithms;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;


public class TestGraphAlgorithms {
	
	ArrayList<Object>[] grafoArrayList;
	LinkedList<Vertice>[] grafoLinkedList;
	LinkedList<Vertice>[] grafoPrimKruskal;
	
	@Before
	public void setUp() throws Exception {
		//Grafo de ArrayList
		grafoArrayList = new ArrayList[13];
		ArrayList<Object> list0 = new ArrayList<Object>();
		list0.add(1);
		list0.add(8);
		grafoArrayList[0] = list0;
		ArrayList<Object> list1 = new ArrayList<Object>();
		list1.add(0);
		list1.add(2);
		list1.add(5);
		grafoArrayList[1] = list1;
		ArrayList<Object> list2 = new ArrayList<Object>();
		list2.add(1);
		list2.add(3);
		grafoArrayList[2] = list2;
		ArrayList<Object> list3 = new ArrayList<Object>();
		list3.add(2);
		grafoArrayList[3] = list3;
		ArrayList<Object> list4 = new ArrayList<Object>();
		list4.add(5);
		list4.add(8);
		grafoArrayList[4] = list4;
		ArrayList<Object> list5 = new ArrayList<Object>();
		list5.add(4);
		list5.add(6);
		grafoArrayList[5] = list5;
		ArrayList<Object> list6 = new ArrayList<Object>();
		list6.add(5);
		list6.add(7);
		grafoArrayList[6] = list6;
		ArrayList<Object> list7 = new ArrayList<Object>();
		list7.add(6);
		grafoArrayList[7] = list7;
		ArrayList<Object> list8 = new ArrayList<Object>();
		list8.add(4);
		list8.add(9);
		grafoArrayList[8] = list8;
		ArrayList<Object> list9 = new ArrayList<Object>();
		list9.add(8);
		list9.add(5);
		list9.add(10);
		grafoArrayList[9] = list9;
		ArrayList<Object> list10 = new ArrayList<Object>();
		list10.add(9);
		grafoArrayList[10] = list10;
		ArrayList<Object> list11 = new ArrayList<Object>();
		list11.add(12);
		grafoArrayList[11] = list11;
		ArrayList<Object> list12 = new ArrayList<Object>();
		list12.add(11);
		grafoArrayList[12] = list12;
		
		//Grafo LinkedList
		grafoLinkedList = new LinkedList[5];
		LinkedList<Vertice> list13 = new LinkedList<Vertice>();
		Vertice v1 = new Vertice(1,10);
		list13.add(v1);
		Vertice v2 = new Vertice(4,100);
		list13.add(v2);
		Vertice v3 = new Vertice(3,30);
		list13.add(v3);
		grafoLinkedList[0] = list13;
		LinkedList<Vertice> list14 = new LinkedList<Vertice>();
		Vertice v4 = new Vertice(2,50);
		list14.add(v4);
		grafoLinkedList[1] = list14;
		LinkedList<Vertice> list15 = new LinkedList<Vertice>();
		Vertice v5 = new Vertice(4,10);
		list15.add(v5);
		grafoLinkedList[2] = list15;
		LinkedList<Vertice> list16 = new LinkedList<Vertice>();
		Vertice v6 = new Vertice(2,20);
		list16.add(v6);
		Vertice v7 = new Vertice(4,60);
		list16.add(v7);
		grafoLinkedList[3] = list16;
		LinkedList<Vertice> list17 = new LinkedList<Vertice>();
		grafoLinkedList[4] = list17;
		
		//Grafo para Prim y Kruskal
		grafoPrimKruskal = new LinkedList[7];
		for(int i = 0; i < grafoPrimKruskal.length; i++) {
			grafoPrimKruskal[i] = new LinkedList<Vertice>();
		}
		Vertice v8 = new Vertice(1,2);
		grafoPrimKruskal[0].add(v8);
		Vertice v9 = new Vertice(3,1);
		grafoPrimKruskal[0].add(v9);
		Vertice v10 = new Vertice(2,4);
		grafoPrimKruskal[0].add(v10);
		
		Vertice v11 = new Vertice(0,2);
		grafoPrimKruskal[1].add(v11);
		grafoPrimKruskal[1].add(new Vertice(3,3));
		grafoPrimKruskal[1].add(new Vertice(4,10));
		
		grafoPrimKruskal[2].add(new Vertice(0,4));
		grafoPrimKruskal[2].add(new Vertice(3,2));
		grafoPrimKruskal[2].add(new Vertice(5,5));
		
		grafoPrimKruskal[3].add(new Vertice(0,1));
		grafoPrimKruskal[3].add(new Vertice(1,3));
		grafoPrimKruskal[3].add(new Vertice(2,2));
		grafoPrimKruskal[3].add(new Vertice(5,8));
		grafoPrimKruskal[3].add(new Vertice(6,4));
		grafoPrimKruskal[3].add(new Vertice(4,7));
		
		grafoPrimKruskal[4].add(new Vertice(1,10));
		grafoPrimKruskal[4].add(new Vertice(3,7));
		grafoPrimKruskal[4].add(new Vertice(6,6));
		
		grafoPrimKruskal[5].add(new Vertice(2,5));
		grafoPrimKruskal[5].add(new Vertice(3,8));
		grafoPrimKruskal[5].add(new Vertice(6,1));
		
		grafoPrimKruskal[6].add(new Vertice(5,1));
		grafoPrimKruskal[6].add(new Vertice(3,4));
		grafoPrimKruskal[6].add(new Vertice(4,6));
		
	}

	@Test
	public void testRecorrridoDFS() {
		DFS dfs = new DFS(grafoArrayList);
		dfs.recorrer(0);
	}
	
	@Test
	public void testRecorrridoBFS() {
		BFS bfs = new BFS(grafoArrayList);
		bfs.recorrer(0);
	}
	
	@Test
	public void testDijkstra() {
		Dijkstra dijkstra = new Dijkstra(grafoLinkedList);
		int[] vectorEsperado = {0,10,50,30,60}; 
		int[] vectorPrecedentes = {0,3,0,2};
		dijkstra.obtenerCostoMinimo(0);
		assertArrayEquals(vectorEsperado, dijkstra.costosMinimos);
		assertArrayEquals(vectorPrecedentes, dijkstra.precedentes);
	}	
	
	@Test
	public void testDijkstraPQ() {
		Dijkstra dijkstra = new Dijkstra(grafoLinkedList);
		int[] vectorEsperado = {0,10,50,30,60}; 
		dijkstra.obtenerCostoMinimoPQ(0);
		assertArrayEquals(vectorEsperado, dijkstra.costosMinimos);
	}	
	
	@Test
	public void testPrim() {
		Prim prim = new Prim(grafoPrimKruskal);
		int[] agm = {-1,0,3,0,6,6,3}; 
		prim.obtenerAGM(0);
		assertArrayEquals(agm, prim.agm);
	}	
}
