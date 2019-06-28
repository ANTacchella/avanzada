package coloreo;

public class Nodo implements Comparable<Nodo> {

	public int vertice;
	public int grado;
	int color;
	
	public Nodo( int v, int g ) {
		vertice = v;
		grado = g;
		color = -1;
	}

	@Override
	public int compareTo(Nodo o) {
		return o.grado - this.grado ;
	}

}
