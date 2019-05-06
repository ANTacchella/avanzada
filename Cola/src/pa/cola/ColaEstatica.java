package pa.cola;

public class ColaEstatica implements Cola{
	
	private Object[] cola;
	private int size;
	private int pri;
	private int ult;
	
	public ColaEstatica(int tam) {
		cola = new Object[tam];
		size = 0;
		pri = 0;
		ult = 0;
	}
	
	@Override
	public void offer(Object dato) throws ColaLlenaException {
		if(size == cola.length)
			throw new ColaLlenaException("No es posible insertar nuevos elementos."
										+ "La cola se encuentra llena");
		cola[ult] = dato;
		if(ult == cola.length - 1)
			ult = 0;
		else
			ult++;
		size++;
	}

	@Override
	public Object poll() throws ColaVaciaException {
		if(size == 0)
			throw new ColaVaciaException("No es posible retirar más elementos. "
										+ "La cola se encuentra vacía.");
		Object dato = cola[pri];
		pri = (pri+1)%cola.length;
		size--;
		if(size == 0) {
			pri = ult = 0;
		}
		return dato;
	}

	@Override
	public Object peek() throws RuntimeException {
		if(size == 0)
			throw new ColaVaciaException("No es posible retirar más elementos. "
										+ "La cola se encuentra vacía.");
		return cola[pri];
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void empty() {
		pri = ult = size = 0;		
	}

}
