package pa.cola;

import pa.nodo.Nodo;

public class ColaDinamica implements Cola {

	private Nodo pri;
	private Nodo ult;
	
	public ColaDinamica() {
		pri = ult = null;
	}
	
	@Override
	public void offer(Object dato) {
		Nodo nuevo = new Nodo(dato);
		if(pri == null)
			pri = nuevo;
		else
			ult.setNodoSiguiente(nuevo);
		ult = nuevo;
	}

	@Override
	public Object poll() throws RuntimeException {
		if(isEmpty())
			throw new ColaVaciaException("No es posible retirar más elementos."
										+ "La cola se encuentra vacía.");
		Nodo aux = pri;
		pri = aux.getNodoSiguiente();
		Object dato = aux.getDatos();
		if(isEmpty())
			ult = null;
		return dato;
	}

	@Override
	public Object peek() throws RuntimeException {
		if(isEmpty())
			throw new ColaVaciaException("No es posible retirar más elementos."
										+ "La cola se encuentra vacía.");
		return pri.getDatos();
	}

	@Override
	public boolean isEmpty() {
		return pri == null;
	}

	@Override
	public void empty() {
		pri = ult = null;
	}

}
