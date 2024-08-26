package adts.bst;

public interface BST<T extends Comparable<T>> extends Iterable<T> {
    public void insert(T data);

    public void remove(T data);

    public boolean contains(T data);

    public T get(T data);

    public T max();

    public T min();

    public int count();

    public void printInOrder();
}
