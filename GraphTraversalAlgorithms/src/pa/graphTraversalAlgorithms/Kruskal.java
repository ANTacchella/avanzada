package pa.graphTraversalAlgorithms;

import java.util.Comparator;
import java.util.LinkedList;

public class Kruskal {
	LinkedList<Arista> grafo;
	UDS uds;
	LinkedList<Arista> agm;
	
	public Kruskal(LinkedList<Arista> grafo, int nVertices) {
		this.grafo = grafo;
		uds = new UDS(nVertices);
		agm = new LinkedList<Arista>();
	}
	
	public void obtenerAGM() {
		Comparator<Arista> aristaComparator = new Comparator<Arista>() {
	        @Override
	        public int compare(Arista a1, Arista a2) {
	            return a1.costo - a2.costo;
	        }
	    };
	    LinkedList<Arista> grafoAux = new LinkedList<Arista>(grafo);
		grafoAux.sort(aristaComparator);
		
		for(Arista a: grafoAux) {
			if(uds.find(a.origen) != uds.find(a.destino)) {
				agm.add(a);
				uds.union(a.origen, a.destino);
			}
		}
	}
}
