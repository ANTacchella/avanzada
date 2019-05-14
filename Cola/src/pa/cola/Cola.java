package pa.cola;

public interface Cola {
	void offer(Object dato);
	Object poll() throws RuntimeException;
	Object peek() throws RuntimeException;
	boolean isEmpty();
	void empty();
}
