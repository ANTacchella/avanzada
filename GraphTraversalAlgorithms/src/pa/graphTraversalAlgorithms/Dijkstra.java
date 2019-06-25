package pa.graphTraversalAlgorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstra {
	
	LinkedList<Vertice>[] grafo;
	boolean[] visitados;
	int[] costosMinimos;
	int[] precedentes;
	Vertice[] padre;
	
	public Dijkstra(LinkedList<Vertice>[] grafo) {
		this.grafo = grafo;
		visitados = new boolean[grafo.length];
		costosMinimos = new int[grafo.length];
		precedentes = new int[grafo.length - 1];
		padre = new Vertice[grafo.length];
	}
	
	public void obtenerCostoMinimo(int verticeInicial) {
		Arrays.fill(costosMinimos, Integer.MAX_VALUE);
		Arrays.fill(precedentes, verticeInicial);
		boolean[] auxOfTrue = new boolean[grafo.length];
		Arrays.fill(auxOfTrue, true);
		costosMinimos[verticeInicial] = 0;
		visitados[verticeInicial] = true;
		int w;
		for(Vertice v: grafo[verticeInicial]) {
			costosMinimos[v.numeroVertice] = v.costo;
		}
		
		while(!Arrays.equals(visitados, auxOfTrue)){
			w = buscarMinimo();
			visitados[w] = true;
			
			for(Vertice v1: grafo[w]) {
				if(costosMinimos[v1.numeroVertice] > costosMinimos[w] + v1.costo) {
					costosMinimos[v1.numeroVertice] = costosMinimos[w] + v1.costo;
					precedentes[v1.numeroVertice - 1] = w;
				}
			}
		}
		
	}
	
	public void obtenerCostoMinimoPQ(int verticeInicial) {
		Comparator<Vertice> verticeComparator = new Comparator<Vertice>() {
	        @Override
	        public int compare(Vertice v1, Vertice v2) {
	            return v1.costo - v2.costo;
	        }
	    };
		Vertice w;
		PriorityQueue<Vertice> cola = new PriorityQueue<Vertice>(verticeComparator);
		Arrays.fill(costosMinimos, Integer.MAX_VALUE);
		costosMinimos[verticeInicial] = 0;
		cola.add(new Vertice(verticeInicial, costosMinimos[verticeInicial]));
		
		while(!cola.isEmpty()){
			w = cola.poll();
			visitados[w.numeroVertice] = true;
			for(Vertice v: grafo[w.numeroVertice]) {
				if(!visitados[v.numeroVertice] && costosMinimos[v.numeroVertice] > costosMinimos[w.numeroVertice] + v.costo) {
					costosMinimos[v.numeroVertice] = costosMinimos[w.numeroVertice] + v.costo;
					padre[v.numeroVertice] = w;
					cola.add(new Vertice(v.numeroVertice, costosMinimos[v.numeroVertice]));
				}
			}
		}
		
	}
	
	public int buscarMinimo() {
		boolean flag = false; 
		int costoMinimo = 0;
		int pos = 0;
		for(int i = 1; i < visitados.length; i++) {
			
			if(!flag && !visitados[i]) {
				flag = true;
				costoMinimo = costosMinimos[i];
				pos = i;
			}
			else if(costosMinimos[i] < costoMinimo && !visitados[i]) {
				costoMinimo = costosMinimos[i];
				pos = i;
			}
								
		}
		return pos;
	}
	
}
