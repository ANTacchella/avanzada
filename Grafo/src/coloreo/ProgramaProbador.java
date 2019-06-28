package coloreo;

import java.util.ArrayList;
import java.util.HashMap;

public class ProgramaProbador {

	// 	IN Coloreo
	int v, a;
	int[] sec;
	boolean[][] grafo;
	
	// 	OUT Coloreo
	int cantColores;
	HashMap<Integer, Integer> nodosPintados;
	
	// OUT Pp
	boolean respuesta;

	public ProgramaProbador( int v, int a, int[] s, boolean[][] g, int cc, HashMap<Integer, Integer> np) {
		this.v = v;
		this.a = a;
		sec = s;
		grafo = g;
		cantColores = cc;
		nodosPintados = np;
		respuesta = true;
	}
	public boolean getFC( int i, int j ) {
		boolean retorno;
		if( i > j ) 
			retorno = grafo[j][i];
		else
			retorno = grafo[i][j];
		return retorno;
	}
	
	public boolean resolver() {
		int cc = 0;
		ArrayList<Integer> colores =  new ArrayList<>();
		
		for( int i=0; i<v && respuesta; i++ ) {
			if( i==0 || !colores.contains( nodosPintados.get(i) ) ) {
				cc++;
				colores.add( nodosPintados.get(i) );
			}
			if( cc > cantColores )
				respuesta = false;
			for( int j=i+1; j<v && respuesta; j++ ) {
				if( getFC(i,j) && nodosPintados.get(i) == nodosPintados.get(j) )
					respuesta = false;
			}
		}
		if( cc != cantColores )
			respuesta = false;
		
		return respuesta;
	}
}
