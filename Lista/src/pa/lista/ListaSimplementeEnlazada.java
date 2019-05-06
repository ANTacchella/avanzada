package pa.lista;

import pa.nodo.*;

public class ListaSimplementeEnlazada {
	private Nodo primerNodo;
	private Nodo ultimoNodo;
	private String nombre;
	
	public ListaSimplementeEnlazada() {
		this("lista");
	}
	
	public ListaSimplementeEnlazada(String nombre) {
		this.nombre = nombre;
		primerNodo = ultimoNodo = null;
	}
	
	public Nodo getPrimerNodo() {
		return primerNodo;
	}

	public Nodo getUltimoNodo() {
		return ultimoNodo;
	}

	public void pushBack(Object dato) {
		if(isEmpty())
			primerNodo = ultimoNodo = new Nodo(dato);
		else {
			ultimoNodo.setNodoSiguiente(new Nodo(dato));
			ultimoNodo = ultimoNodo.getNodoSiguiente();
		}
	}
	
	public Object popBack() throws ListaVaciaException{
		Nodo actual;
		if(isEmpty())
			throw new ListaVaciaException("No hay más datos que retirar. "
										+ "La " + nombre + " lista está vacía.");
		Object datoEliminado = ultimoNodo.getDatos();
		
		if(primerNodo == ultimoNodo)
			primerNodo = ultimoNodo = null;
		
		else {
			actual = primerNodo;
			
			while(actual.getNodoSiguiente() != ultimoNodo)
				actual = actual.getNodoSiguiente();
			ultimoNodo = actual;
			actual.setNodoSiguiente(null);
		}
		
		return datoEliminado;
	}
	
	public void pushFront(Object dato) {
		Nodo aux;
		if(isEmpty())
			primerNodo = ultimoNodo = new Nodo(dato);
		
		else {
			aux = new Nodo(dato, primerNodo);
			primerNodo = aux;
		}	
	}
	
	public Object popFront() throws ListaVaciaException { 
		if(isEmpty())
			throw new ListaVaciaException("No hay más datos que retirar. "
					+ "La " + nombre + " está vacía.");
		
		Object datoEliminado = primerNodo.getDatos();
		
		if(primerNodo == ultimoNodo)
			primerNodo = ultimoNodo = null;
		
		else
			primerNodo = primerNodo.getNodoSiguiente();
		
		return datoEliminado;
	}
	
	public void remove(Object datoAEliminar) throws ListaVaciaException, DatoNoEncontradoException {
		Nodo actual = primerNodo;
		boolean res_comp = false;
		if(isEmpty())
			throw new ListaVaciaException("No hay más datos que retirar. "
					+ "La lista está vacía.");
		if(primerNodo.equals(new Nodo(datoAEliminar)))
			primerNodo = primerNodo.getNodoSiguiente();
		else {	
			while(actual != ultimoNodo && !(res_comp = actual.getNodoSiguiente().equals(new Nodo(datoAEliminar))))
				actual = actual.getNodoSiguiente();
			if(!res_comp) 
				throw new DatoNoEncontradoException("No se encontró el elemento a retirar.");
			Nodo nodoAEliminar = actual.getNodoSiguiente();
			if(nodoAEliminar == ultimoNodo)
				ultimoNodo = actual;
			actual.setNodoSiguiente(nodoAEliminar.getNodoSiguiente());
		}			
	}
	
	public void reverse() {
		if(isEmpty())
			throw new ListaVaciaException("La lista está vacía.");
		
		Nodo anterior = null;
		Nodo actual = primerNodo;
		Nodo siguiente = null;
		Nodo aux;
		
		while(actual != null) {
			siguiente = actual.getNodoSiguiente();
			actual.setNodoSiguiente(anterior);
			anterior = actual;
			actual = siguiente;
		}
		
		aux = primerNodo;
		primerNodo = ultimoNodo;
		ultimoNodo = aux;
	}
	
	public void insertAt(int pos, Object dato) throws DatoNoEncontradoException{
		
		Nodo actual = primerNodo;
		if(pos == size())
			pushBack(dato);
		if(pos == 0)
			pushFront(dato);
		else {
			while(actual != null && pos > 1) {
				actual = actual.getNodoSiguiente();
				pos--;
			}
			if(pos != 1) 
				throw new DatoNoEncontradoException("No se encontró la posición buscada.");
			
			Nodo aux = new Nodo(dato);
			aux.setNodoSiguiente(actual.getNodoSiguiente());
			actual.setNodoSiguiente(aux);
		}
	}
	
	public void eraseAt(int pos) throws DatoNoEncontradoException{
		
		Nodo actual = primerNodo;
		if(pos == 0) {
			if(primerNodo == ultimoNodo)
				primerNodo = ultimoNodo = null;
			primerNodo = primerNodo.getNodoSiguiente();
		}
		else {
			while(actual.getNodoSiguiente() != null && pos > 1) {
				actual = actual.getNodoSiguiente();
				pos--;
			}
			if(actual.getNodoSiguiente() == null)
				throw new DatoNoEncontradoException("No se encontró la posición buscada.");
			
			Nodo siguiente = actual.getNodoSiguiente();
			if(siguiente  == ultimoNodo)
				ultimoNodo = actual;
			actual.setNodoSiguiente(siguiente.getNodoSiguiente());
		}
	}
	
	public boolean isEmpty() {
		return primerNodo == null;
	}
	
	public void empty() {
		primerNodo = ultimoNodo = null;
	}
	
	public boolean search(Object dato) throws ListaVaciaException{
		boolean res_comp = false;
		if(isEmpty())
			throw new ListaVaciaException("La lista está vacía.");
		Nodo actual = primerNodo;
		while(actual != null && !(res_comp = actual.equals(new Nodo(dato)))) {
			actual = actual.getNodoSiguiente();
		}
		return res_comp;
	}
	
	public Object searchAt(int pos) throws DatoNoEncontradoException{
		
		Nodo actual = primerNodo;
		Nodo aux;
		if(pos == 0) 
			return primerNodo.getDatos();
		else {
			while(actual.getNodoSiguiente() != null && pos > 1) {
				actual = actual.getNodoSiguiente();
				pos--;
			}
			if(actual.getNodoSiguiente() == null)
				throw new DatoNoEncontradoException("No se encontró la posición buscada.");
			
			aux = actual.getNodoSiguiente();
		}
		return aux.getDatos();
	}

	
	public int size() {
		int size = 0;

		Nodo actual = primerNodo;
		
		while(actual != null) {
			actual = actual.getNodoSiguiente();
			size++;
		}
		return size;
	}
}
