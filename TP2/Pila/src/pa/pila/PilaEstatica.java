package pa.pila;

public class PilaEstatica implements Pila{
	
	private Object[] pila;
	private int tope;
	
	public PilaEstatica() {
		pila = new Object[2];
		tope = 0;
	}
	
	@Override
	public void push(Object dato) throws PilaLlenaException{
		if (tope == pila.length) 
			pila = java.util.Arrays.copyOf(pila, pila.length * 2);
		pila[tope++] = dato;
	}

	@Override
	public Object pop() throws PilaVaciaException{
		if (isEmpty()) 
			throw new PilaVaciaException("No es posible desapilar más elementos. "
											+ "La pila se encuentra vacía.");
		return pila[--tope];
	}

	@Override
	public Object peek() throws PilaVaciaException {
		if (isEmpty()) 
			throw new PilaVaciaException("La pila se encuentra vacía.");
		return pila[tope - 1];
	}

	@Override
	public boolean isEmpty() {
		return tope == 0;
	}

	@Override
	public void empty() {
		tope = 0;		
	}
	
}
