package pa.punto3;

import org.junit.Test;

import pa.pila.*;
import pa.cola.*;

public class ApilarIntegers {

	@Test
	public void tiempoPilaEstatica() {
		long startTime = System.currentTimeMillis();
		PilaEstatica pilaEstatica = new PilaEstatica();
		for (int i = 0; i < 1000000; i++) {
			pilaEstatica.push(5);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

	@Test
	public void tiempoPilaDinamica() {
		long startTime = System.currentTimeMillis();
		PilaDinamica pilaDinamica = new PilaDinamica();
		for (int i = 0; i < 1000000; i++) {
			pilaDinamica.push(5);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
	
	@Test
	public void tiempoColaEstatica() {
		long startTime = System.currentTimeMillis();
		ColaEstatica colaEstatica = new ColaEstatica();
		for (int i = 0; i < 1000000; i++) {
			colaEstatica.offer(5);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

	@Test
	public void tiempoColaDinamica() {
		long startTime = System.currentTimeMillis();
		ColaDinamica colaDinamica = new ColaDinamica();
		for (int i = 0; i < 1000000; i++) {
			colaDinamica.offer(5);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
	
}
