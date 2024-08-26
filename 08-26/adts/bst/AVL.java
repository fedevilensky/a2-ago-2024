package adts.bst;

import java.util.Iterator;

import adts.list.LinkedList;
import adts.list.List;

public class AVL<T extends Comparable<T>> implements BST<T> {

  class AVLNode<T> {
    T data;
    AVLNode<T> left = null;
    AVLNode<T> right = null;
    int height = 1;
    // count nos permite contar cuantos repetidos hay
    int count = 1;

    AVLNode(T data) {
      this.data = data;
    }
  }

  private AVLNode<T> root = null;
  int elements = 0;

  private boolean containsAux(T data, AVLNode<T> node) {
    if (node == null) {
      return false;
    }
    if (data == node.data) {
      return true;
    }
    if (data.compareTo(node.data) < 0) {
      return containsAux(data, node.left);
    }
    // else
    return containsAux(data, node.right);
  }

  private T maxAux(AVLNode<T> node) {
    if (node.right != null) {
      return maxAux(node.right);
    }

    return node.data;
  }

  private void printInOrderAux(AVLNode<T> node) {
    if (node == null) {
      return;
    }

    printInOrderAux(node.left);
    System.out.println(node.data);
    printInOrderAux(node.right);
  }

  private int max(int a, int b) {
    if (a > b) {
      return a;
    }

    return b;
  }

  private int height(AVLNode<T> n) {
    if (n == null) {
      return 0;
    }

    return n.height;
  }

  private int balanceFactor(AVLNode<T> n) {
    return height(n.right) - height(n.left);
  }

  private AVLNode<T> leftRotation(AVLNode<T> node) {

    AVLNode<T> z = node;
    AVLNode<T> y = node.right;

    z.right = y.left;
    y.left = z;

    z.height = 1 + max(height(z.left), height(z.right));
    y.height = 1 + max(height(y.left), height(y.right));

    return y;
  }

  private AVLNode<T> rebalance(AVLNode<T> node) {
    int bF = balanceFactor(node);
    // hay un desbalance Der-?
    if (bF > 1) {
      int bFRight = balanceFactor(node.right);
      // hay un desbalance Der-Der
      if (bFRight > 0) {
        node = leftRotation(node);
      }
      // hay un desbalance Der-Izq
      if (bFRight < 0) {
        node = rightLeftRotation(node);
      }
    }
    // hay un desbalance Izq-?
    if (bF < -1) {
      int bFLeft = balanceFactor(node.left);
      // hay un desbalance Izq-Der
      if (bFLeft > 0) {
        node = leftRightRotation(node);
      }
      // hay un desbalance Izq-Izq
      if (bFLeft < 0) {
        node = rightRotation(node);
      }
    }
    return node;
  }

  private AVL<T>.AVLNode<T> rightRotation(AVL<T>.AVLNode<T> node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'rightRotation'");
  }

  private AVL<T>.AVLNode<T> leftRightRotation(AVL<T>.AVLNode<T> node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'leftRightRotation'");
  }

  private AVL<T>.AVLNode<T> rightLeftRotation(AVL<T>.AVLNode<T> node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'rightLeftRotation'");
  }

  private AVLNode<T> insertAux(T data, AVLNode<T> node) {
    if (node == null) {
      this.elements++;
      return new AVLNode<T>(data);
    }

    if (data == node.data) {
      this.elements++;
      node.count++;
      return node;
    }

    if (data.compareTo(node.data) < 0) {
      node.left = insertAux(data, node.left);
    } else // if (data > node.data);
    {
      node.right = insertAux(data, node.right);
    }

    node.height = 1 + max(height(node.left), height(node.right));

    node = rebalance(node);

    return node;
  }

  private void inOrderLoad(List<T> l, AVLNode<T> node) {
    if (node == null) {
      return;
    }
    inOrderLoad(l, node.left);
    l.add(node.data);
    inOrderLoad(l, node.right);
  }

  private AVLNode<T> removeAux(T data, AVLNode<T> node) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'removeAux'");
  }

  @Override
  public Iterator<T> iterator() {
    List<T> l = new LinkedList<T>();

    inOrderLoad(l, root);

    return l.iterator();
  }

  @Override
  public void insert(T data) {
    root = insertAux(data, root);
  }

  @Override
  public void remove(T data) {
    root = removeAux(data, root);
  }

  @Override
  public boolean contains(T data) {
    return containsAux(data, root);
  }

  @Override
  public T get(T data) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'get'");
  }

  @Override
  public T max() {
    return maxAux(root);
  }

  @Override
  public T min() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'min'");
  }

  @Override
  public int count() {
    return elements;
  }

  @Override
  public void printInOrder() {
    printInOrderAux(root);
  }

}
