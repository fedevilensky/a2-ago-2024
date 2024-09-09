package adts.priority_queue;

public interface PriorityQueue<T, P extends Comparable<P>> {
  void enqueue(T data, P prority);

  T peek();

  T dequeue();

  boolean isEmpty();

  int size();

  boolean isFull();
}
