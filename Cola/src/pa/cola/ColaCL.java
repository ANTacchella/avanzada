package pa.cola;

import pa.lista.ListaSimplementeEnlazada;

public class ColaCL implements Cola {
	
	ListaSimplementeEnlazada listaC;
	
	public ColaCL() {
		listaC = new ListaSimplementeEnlazada("cola"); 
	}

	@Override
	public void offer(Object dato) {
		listaC.pushBack(dato);
	}

	@Override
	public Object poll() throws ColaVaciaException {
		return listaC.popFront();
	}

	@Override
	public Object peek() throws RuntimeException {
		return listaC.getPrimerNodo().getDatos();
	}

	@Override
	public boolean isEmpty() {
		return listaC.isEmpty();
	}

	@Override
	public void empty() {
		listaC.empty();
	}

}
