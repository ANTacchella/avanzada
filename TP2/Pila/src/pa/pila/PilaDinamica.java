package pa.pila;

import pa.nodo.*;

public class PilaDinamica implements Pila {
	private Nodo tope;
	
	public PilaDinamica() {
		tope = null;
	}
	
	@Override
	public void push(Object dato) {
		Nodo nuevo =  new Nodo(dato, tope);
		tope = nuevo;
	}

	@Override
	public Object pop() {
		if(isEmpty())
			throw new PilaVaciaException("No es posible desapilar más elementos. " 
										+ "La pila se encuentra vacía.");
		Nodo aux = tope;
		tope = aux.getNodoSiguiente();
		return aux.getDatos();
	}

	@Override
	public Object peek() {
		if(isEmpty())
			throw new PilaVaciaException("No es posible desapilar más elementos. " 
										+ "La pila se encuentra vacía.");
		return tope.getDatos();
	}

	@Override
	public boolean isEmpty() {
		return tope == null;
	}

	@Override
	public void empty() {
		tope = null;
	}

}
