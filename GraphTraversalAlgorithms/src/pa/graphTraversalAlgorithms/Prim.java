package pa.graphTraversalAlgorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Prim {
	
	LinkedList<Vertice>[] grafo;
	int[] agm;
	int[] distancia;
	boolean[] visitados;
	
	public Prim(LinkedList<Vertice>[] grafo) {
		this.grafo = grafo;
		agm = new int[grafo.length];
		distancia = new int[grafo.length];
		visitados = new boolean[grafo.length];
	}
	
	public void obtenerAGM(int verticeInicial) {
		Comparator<Vertice> verticeComparator = new Comparator<Vertice>() {
			@Override
			public int compare(Vertice v1, Vertice v2) {
				return v1.costo - v2.costo;
			}
		};
		Vertice w;
		PriorityQueue<Vertice> cola = new PriorityQueue<Vertice>(verticeComparator);
		Arrays.fill(distancia, Integer.MAX_VALUE);
		Arrays.fill(agm, -1);
		distancia[verticeInicial] = 0;
		cola.add(new Vertice(verticeInicial, distancia[verticeInicial]));

		while (!cola.isEmpty()) {
			w = cola.poll();
			visitados[w.numeroVertice] = true;
			for (Vertice v : grafo[w.numeroVertice]) {
				if (!visitados[v.numeroVertice] && distancia[v.numeroVertice] > v.costo) {
					distancia[v.numeroVertice] = v.costo;
					agm[v.numeroVertice] = w.numeroVertice;
					cola.add(new Vertice(v.numeroVertice, distancia[v.numeroVertice]));
				}
			}
		}

	}
}