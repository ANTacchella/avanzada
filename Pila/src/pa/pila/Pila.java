package pa.pila;

public interface Pila {
	
	void push(Object dato) throws RuntimeException;
	Object pop() throws RuntimeException;
	Object peek() throws RuntimeException;
	boolean isEmpty();
	void empty();
}
