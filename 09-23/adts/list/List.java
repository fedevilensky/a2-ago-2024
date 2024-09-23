package adts.list;

public interface List<T> extends Iterable<T> {
  void add(T data);

  void remove(T data);

  void remove();

  void addFirst(T data);

  T get(int i);

  boolean contains(T data);

  int length();
}
