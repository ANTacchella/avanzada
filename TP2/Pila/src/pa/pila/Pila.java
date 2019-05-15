package pa.pila;

public interface Pila {
	
	void push(Object dato);
	Object pop() throws RuntimeException;
	Object peek() throws RuntimeException;
	boolean isEmpty();
	void empty();
}
