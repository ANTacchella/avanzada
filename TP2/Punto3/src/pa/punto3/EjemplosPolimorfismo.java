package pa.punto3;

import java.util.ArrayList;

import pa.pila.*;
import pa.cola.*;

public class EjemplosPolimorfismo {
	
	public static void main(String[] args) {
		ArrayList<Pila> pilas = new ArrayList<Pila>();
		PilaDinamica pilaD = new PilaDinamica();
		PilaEstatica pilaE = new PilaEstatica();
		PilaHL pilaHl = new PilaHL();
		PilaCL pilaCl = new PilaCL();
		pilas.add(pilaD);
		pilas.add(pilaE);
		pilas.add(pilaHl);
		pilas.add(pilaCl);
		for (Pila pila : pilas) { //A partir de este for es donde se evidencia el polimorfismo. Utilizando mensajes sintacticamente iguales, objetos
			pila.push(10);		 //distintos realizan la misma accion	
			pila.push(11);
			System.out.println(pila.peek());
			System.out.println(pila.pop());
			pila.empty();
			System.out.println(pila.isEmpty());
		}
		
		ArrayList<Cola> colas = new ArrayList<Cola>();
		ColaDinamica colaD = new ColaDinamica();
		ColaEstatica colaE = new ColaEstatica();
		ColaHL colaHl = new ColaHL();
		ColaCL colaCl = new ColaCL();
		colas.add(colaD);
		colas.add(colaE);
		colas.add(colaHl);
		colas.add(colaCl);
		for (Cola cola : colas) { //A partir de este for es donde se evidencia el polimorfismo. Utilizando mensajes sintacticamente iguales, objetos 
			cola.offer("String1"); //distintos realizan la misma accion
			cola.offer("String2");
			System.out.println(cola.poll());
			System.out.println(cola.peek());
			cola.empty();
			System.out.println(cola.isEmpty());
		}
	}
}
