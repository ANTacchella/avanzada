package coloreo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Coloreo {

	// IN
	boolean grafo[][];
	int cantVertices;
	int cantAristas;
	int secuencia[];
	
	// OUT
	HashMap<Integer, Integer> nodosPintados;
	ArrayList<Nodo> listaNodos;
	int cantColores;
	
	public Coloreo( int v, int a ) {
		cantVertices = v; 
		cantAristas = a;
		grafo = new boolean[v][v];
		
		cantColores = 0;
		nodosPintados = new HashMap<>();
		listaNodos = new ArrayList<>();
	}
	public void agregarArista( int i, int f ) {
		if( i > f )
			grafo[f][i] = true;
		else
			grafo[i][f] = true;
	}
	public boolean getFC( int i, int j ) {
		boolean retorno;
		if( i > j ) 
			retorno = grafo[j][i];
		else
			retorno = grafo[i][j];
		return retorno;
	}
	
	public void resolver( int[] sec ) {
		
		secuencia = sec;
		int verticeActual;
		int noHayConexion;
		
		while( nodosPintados.size() < cantVertices ) { // Recorre hasta que se hayan pintado todos los nodos.
			
			cantColores++;
			for( int i=0; i< cantVertices; i++ ) { // Para recorrer la secuencia.
				noHayConexion = 0;
				verticeActual = secuencia[ i ];
				int j=0;
				while( j<cantVertices &&  !nodosPintados.containsKey(verticeActual) ) {	// Para encontrar si tiene algun nodo adyacente.
					
					if( !getFC( verticeActual, j) ) {
						noHayConexion++;
					} else if( !nodosPintados.containsKey( j ) ) {
						noHayConexion++;
					} else if( nodosPintados.get( j ) != cantColores ) {
						noHayConexion++;
					}
					else
						break;
					
					j++;
				}
				if( noHayConexion == cantVertices )
					nodosPintados.put( verticeActual, cantColores);
			}
		} 
	}
	
	public int[] calcularSecuencia( int queSecuencia ) { // Si es 1 devuelvo WP, si es 2 Matula
		Nodo secuencia[] = new Nodo[cantVertices];
		int sec[] = new int[cantVertices];
		
		for( int i=0; i<cantVertices; i++ ) {
			secuencia[i] = new Nodo(i, 0);
			for( int j=0; j< cantVertices; j++ ) {
				if( getFC(i, j) ) {
					secuencia[i].grado++;
				}
			}
		}
		
		Arrays.sort( secuencia );
		if( queSecuencia == 1 ) {
			for( int i=0; i<cantVertices; i++ ) {
				sec[i] = secuencia[i].vertice;
			}
		} else if( queSecuencia == 2 ) {
			for( int i=0; i<cantVertices; i++ ) {
				sec[i] = secuencia[cantVertices-i-1].vertice;
			}
		}
		
//		for( int i=0; i<cantVertices; i++ ) {
//			System.out.println( sec[i] );
//		}
		return sec;
	}
}
