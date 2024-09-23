package adts.list;

import java.util.Iterator;

public class LinkedList<T> implements List<T> {
  class LinkedListIterator<T> implements Iterator<T> {
    LinkedListNode<T> curr;

    @Override
    public boolean hasNext() {
      return curr != null;
    }

    @Override
    public T next() {
      T data = curr.data;
      curr = curr.next;
      return data;
    }

    LinkedListIterator(LinkedListNode<T> head) {
      curr = head;
    }
  }

  class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    LinkedListNode() {
      next = null;
    }

    LinkedListNode(T data) {
      this.data = data;
      this.next = null;
    }

    LinkedListNode(T data, LinkedListNode<T> next) {
      this.data = data;
      this.next = next;
    }
  };

  private int size = 0;
  private LinkedListNode<T> head = null;
  private LinkedListNode<T> tail = null;

  @Override
  public void add(T data) {
    LinkedListNode<T> newNode = new LinkedListNode<T>(data);
    if (size == 0) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      tail.next = newNode;
      tail = tail.next;
    }
    size++;
  }

  @Override
  public void remove(T data) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public void remove() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public void addFirst(T data) {
    LinkedListNode<T> newNode = new LinkedListNode<T>(data);
    if (size == 0) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
    size++;
  }

  @Override
  public T get(int i) {
    LinkedListNode<T> curr = head;
    for (int pos = 0; pos < i; pos++) {
      curr = curr.next;
    }
    return curr.data;
  }

  @Override
  public boolean contains(T data) {
    LinkedListNode<T> curr = head;
    while (curr != null) {
      if (curr.data == data) {
        return true;
      }

      curr = curr.next;
    }
    return false;
  }

  @Override
  public int length() {
    return size;
  }

  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator<T>(head);
  }
}
