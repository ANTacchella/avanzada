package pa.graphTraversalAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	ArrayList<Object>[] grafo;
	Queue<Object> cola = new LinkedList<Object>();
	int[] distancias;
	
	public BFS(ArrayList<Object>[] grafo) {
		this.grafo = grafo;
		distancias = new int[grafo.length];
		Arrays.fill(distancias, -1);
	}
	
	public void recorrer(Object verticeInicial) {
		cola.add(verticeInicial);
		distancias[(int) verticeInicial] = 0;
		while(!cola.isEmpty()) {
			Object tope = cola.poll();
			for(Object w: grafo[(int) tope]) {
				if(distancias[(int) w] == -1) {
					distancias[(int) w] = distancias[(int) tope] + 1;
					cola.add(w);
				}
			}			
			
		}
		
	}
}
