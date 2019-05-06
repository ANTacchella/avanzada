package pa.cola;

public interface Cola {
	void offer(Object dato) throws RuntimeException;
	Object poll() throws RuntimeException;
	Object peek() throws RuntimeException;
	boolean isEmpty();
	void empty();
}
