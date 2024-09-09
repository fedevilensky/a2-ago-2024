package adts.priority_queue;

import adts.Pair;

public class MinHeap<T, P extends Comparable<P>>
    implements PriorityQueue<T, P> {

  private Object[] arr;
  private int elements;

  MinHeap(int expectedSize) {
    arr = new Object[expectedSize + 1];
    elements = 0;
  }

  int getParent(int pos) {
    return pos / 2;
  }

  void swap(int pos1, int pos2) {
    Pair<T, P> aux = (Pair<T, P>) arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = aux;
  }

  void siftUp(int pos) {
    if (pos == 1) {
      return;
    }

    int parentPos = getParent(pos);

    Pair<T, P> parent = (Pair<T, P>) arr[parentPos];
    Pair<T, P> posPair = (Pair<T, P>) arr[pos];

    if (posPair.snd.compareTo(parent.snd) < 0) {
      swap(pos, parentPos);
      siftUp(parentPos);
    }
  }

  @Override
  public void enqueue(T data, P prority) {
    if (isFull()) {
      throw new RuntimeException("the queue is full");
    }
    elements++;
    arr[elements] = new Pair<T, P>(data, prority);
    siftUp(elements);
  }

  @Override
  public T peek() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'peek'");
  }

  @Override
  public T dequeue() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'dequeue'");
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'size'");
  }

  @Override
  public boolean isFull() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isFull'");
  }

}
