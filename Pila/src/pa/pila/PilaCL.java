package pa.pila;

import pa.lista.ListaSimplementeEnlazada;
import pa.lista.ListaVaciaException;

public class PilaCL implements Pila {
	private ListaSimplementeEnlazada listaP;
	
	public PilaCL() {
		listaP = new ListaSimplementeEnlazada("pila");
	}
	
	@Override
	public void push(Object dato) {
		listaP.pushFront(dato);
	}

	@Override
	public Object pop() throws ListaVaciaException {
		return listaP.popFront();
	}

	@Override
	public Object peek() {
		return listaP.getPrimerNodo();
	}

	@Override
	public boolean isEmpty() {
		return listaP.isEmpty();
	}

	@Override
	public void empty() {
		listaP.empty();
	}

}
