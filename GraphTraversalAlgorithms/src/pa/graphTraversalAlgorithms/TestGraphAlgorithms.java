package pa.graphTraversalAlgorithms;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestGraphAlgorithms {
	
	ArrayList<Object>[] grafo;
	
	@Before
	public void setUp() throws Exception {
		grafo = new ArrayList[13];
		ArrayList<Object> list0 = new ArrayList<Object>();
		list0.add(1);
		list0.add(8);
		grafo[0] = list0;
		ArrayList<Object> list1 = new ArrayList<Object>();
		list1.add(0);
		list1.add(2);
		list1.add(5);
		grafo[1] = list1;
		ArrayList<Object> list2 = new ArrayList<Object>();
		list2.add(1);
		list2.add(3);
		grafo[2] = list2;
		ArrayList<Object> list3 = new ArrayList<Object>();
		list3.add(2);
		grafo[3] = list3;
		ArrayList<Object> list4 = new ArrayList<Object>();
		list4.add(5);
		list4.add(8);
		grafo[4] = list4;
		ArrayList<Object> list5 = new ArrayList<Object>();
		list5.add(4);
		list5.add(6);
		list5.add(7);
		grafo[5] = list5;
		ArrayList<Object> list6 = new ArrayList<Object>();
		list6.add(5);
		list6.add(7);
		grafo[6] = list6;
		ArrayList<Object> list7 = new ArrayList<Object>();
		list7.add(6);
		grafo[7] = list7;
		ArrayList<Object> list8 = new ArrayList<Object>();
		list8.add(4);
		list8.add(9);
		grafo[8] = list8;
		ArrayList<Object> list9 = new ArrayList<Object>();
		list9.add(8);
		list9.add(5);
		list9.add(10);
		grafo[9] = list9;
		ArrayList<Object> list10 = new ArrayList<Object>();
		list10.add(9);
		grafo[10] = list10;
		ArrayList<Object> list11 = new ArrayList<Object>();
		list11.add(12);
		grafo[11] = list11;
		ArrayList<Object> list12 = new ArrayList<Object>();
		list12.add(11);
		grafo[12] = list12;
	}

	@Test
	public void testRecorrridoDFS() {
		DFS dfs = new DFS(grafo);
		dfs.recorrer(0);
	}

}
