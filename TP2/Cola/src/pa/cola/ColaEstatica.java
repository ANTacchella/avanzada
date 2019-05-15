package pa.cola;

public class ColaEstatica implements Cola{
	
	private Object[] cola;
	private int size;
	private int pri;
	private int ult;
	
	public ColaEstatica() {
		cola = new Object[2];
		size = 0;
		pri = 0;
		ult = 0;
	}
	
	@Override
	public void offer(Object dato) {
		if(size == cola.length)
			cola = java.util.Arrays.copyOf(cola, cola.length * 2);
		cola[ult] = dato;
		ult++;
		size++;
	}

	@Override
	public Object poll() throws ColaVaciaException {
		if(size == 0)
			throw new ColaVaciaException("No es posible retirar más elementos. "
										+ "La cola se encuentra vacía.");
		Object dato = cola[pri];
		pri = pri+1;
		size--;
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
