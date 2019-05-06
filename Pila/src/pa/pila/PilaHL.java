package pa.pila;
import pa.lista.ListaSimplementeEnlazada;
import pa.lista.ListaVaciaException;

public class PilaHL extends ListaSimplementeEnlazada implements Pila {
	
	public PilaHL() {
		super("pila");
	}
	
	@Override
	public void push(Object dato) {
		pushFront(dato);
	}

	@Override
	public Object pop() throws ListaVaciaException {
		return popFront();
	}

	@Override
	public Object peek() {
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
