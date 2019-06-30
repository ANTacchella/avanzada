package pa.graphTraversalAlgorithms;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {

	ArrayList<Object>[] grafo;
	Stack<Object> pila = new Stack<Object>();
	boolean[] visitados;
	
	public DFS(ArrayList<Object>[] grafo) {
		this.grafo = grafo;
		visitados = new boolean[grafo.length];
	}
	
	public void recorrer(Object verticeInicial) {
		pila.push(verticeInicial);
		visitados[(int) verticeInicial] = true;
		while(!pila.isEmpty()) {
			Object v = pila.pop();
			for(Object w: grafo[(int) v]) {
				if(!visitados[(int) w]) {
					pila.push(w);
					visitados[(int) w] = true;
				}
			}			
		}
		
	}
	
}
