package adts.list;

public class LinkedList<T> implements List<T> {
  class LinkedListNode<T> {
    T data;
    LinkedListNode next;

    LinkedListNode() {
      next = null;
    }

    LinkedListNode(T data) {
      this.data = data;
      this.next = null;
    }

    LinkedListNode(T data, LinkedListNode next) {
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
}
