package pa.cola;

import pa.lista.ListaSimplementeEnlazada;

public class ColaHL extends ListaSimplementeEnlazada implements Cola {

	public ColaHL() {
		super("cola");
	}
	
	@Override
	public void offer(Object dato) {
		pushBack(dato);
	}

	@Override
	public Object poll() throws ColaVaciaException {
		return popFront();
	}

	@Override
	public Object peek() throws ColaVaciaException {
		return getPrimerNodo().getDatos();
	}
	
	@Override
	public boolean isEmpty() {
		return isEmpty();
	}

	@Override
	public void empty() {
		empty();
	}

}
