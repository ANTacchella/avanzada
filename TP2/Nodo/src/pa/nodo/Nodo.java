package pa.nodo;

public class Nodo {
	private Object datos;
	private Nodo nodoSiguiente;
	
	public Nodo(Object datos) {
		this(datos, null);
	}
	
	public Nodo(Object obj, Nodo nodoSig) {
		datos = obj;
		nodoSiguiente = nodoSig;
	}

	public Object getDatos() {
		return datos;
	}

	public void setDatos(Object obj) {
		this.datos = obj;
	}

	public Nodo getNodoSiguiente() {
		return nodoSiguiente;
	}

	public void setNodoSiguiente(Nodo nodoSig) {
		this.nodoSiguiente = nodoSig;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datos == null) ? 0 : datos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nodo other = (Nodo) obj;
		if (datos == null) {
			if (other.datos != null)
				return false;
		} else if (!datos.equals(other.datos))
			return false;
		return true;
	}
	
}
