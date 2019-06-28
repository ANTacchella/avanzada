package pa.graphTraversalAlgorithms;

import java.util.Arrays;

public class UDS {
	int[] altura;
	int[] padre;
	
	public UDS(int n) {
		altura = new int[n];
		Arrays.fill(altura, 1);
		padre = new int[n];
		
		for(int i = 0; i < n; i++) {
			padre[i] = i;
		}
	}
	
	public int find(int x) {
		if(padre[x] != x)
			padre[x] = find(padre[x]);
		return padre[x];
	}
	
	public void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(altura[x] < altura[y])
			padre[x] = y;
		else
			padre[y] = x;
		if(altura[x] == altura[y])
			altura[x] = altura[x] + 1;
	}
}
