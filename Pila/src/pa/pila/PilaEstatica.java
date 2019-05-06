package pa.pila;

public class PilaEstatica implements Pila{
	
	private Object[] pila;
	private int tope;
	
	public PilaEstatica(int tam) {
		pila = new Object[tam];
		tope = 0;
	}
	
	@Override
	public void push(Object dato) throws PilaLlenaException{
		if (this.tope == pila.length) 
			throw new PilaLlenaException("No es posible insertar nuevos elementos. "
											+ "La pila se encuentra llena.");
		this.pila[this.tope++] = dato;
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
