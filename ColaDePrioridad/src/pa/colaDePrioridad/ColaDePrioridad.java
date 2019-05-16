package pa.colaDePrioridad;

import pa.cola.Cola;
import pa.monticulo.Monticulo;

public class ColaDePrioridad implements Cola {
	
	Monticulo colaPrioridad = new Monticulo();
	
	@Override
	public void offer(Object dato) {
		colaPrioridad.insertar((int)dato);
	}

	@Override
	public Object poll() throws RuntimeException {
		return colaPrioridad.quitar();
	}

	@Override
	public Object peek() throws RuntimeException {
		return colaPrioridad.getMasPrioritario();
	}

	@Override
	public boolean isEmpty() {
		return colaPrioridad.isEmpty();
	}

	@Override
	public void empty() {
		colaPrioridad.empty();
	}

}
