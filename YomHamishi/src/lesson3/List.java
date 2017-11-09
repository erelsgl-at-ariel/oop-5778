package lesson3;

public interface List<T> extends Collection<T> {
	T get(int index);
	void put(T item, int index);
}
