#pragma once

#include "bst.cpp"
#include <iostream>

template <class T>
struct AVLNode
{
  T data;
  AVLNode<T> *left = nullptr;
  AVLNode<T> *right = nullptr;
  int height = 1;
  // count nos permite contar cuantos repetidos hay
  int count = 1;

  AVLNode(T data)
  {
    this->data = data;
  }
};

template <class T>
class avl : public bst<T>
{
private:
  AVLNode<T> *root = nullptr;
  int elements = 0;

  bool containsAux(T data, AVLNode<T> *node)
  {
    if (node == nullptr)
    {
      return false;
    }
    if (data == node->data)
    {
      return true;
    }
    if (data < node->data)
    {
      return containsAux(data, node->left);
    }
    // else
    return containsAux(data, node->right);
  }

  T maxAux(AVLNode<T> *node)
  {
    if (node->right != nullptr)
    {
      return maxAux(node->right);
    }

    return node->data;
  }

  void printInOrderAux(AVLNode<T> *node)
  {
    if (node == nullptr)
    {
      return;
    }

    printInOrderAux(node->left);
    std::cout << node->data << std::endl;
    printInOrderAux(node->right);
  }

  int max(int a, int b)
  {
    if (a > b)
    {
      return a;
    }

    return b;
  }

  int height(AVLNode<T> *n)
  {
    if (n == nullptr)
    {
      return 0;
    }

    return n->height;
  }

  int balanceFactor(AVLNode<T> *n)
  {
    return height(n->right) - height(n->left);
  }

  AVLNode<T> *leftRotation(AVLNode<T> node)
  {
    /*
     *     z              y
     *    / \            / \
     *   a   y    =>    z   x
     *      / \        / \
     *     b   x      a   b
     */

    AVLNode<T> *z = node;
    AVLNode<T> *y = node->right;

    z->right = y->left;
    y->left = z;

    z->height = 1 + max(height(z->left), height(z->right));
    y->height = 1 + max(height(y->left), height(y->right));

    return y;
  }

  AVLNode<T> *rebalance(AVLNode<T> *node)
  {
    int bF = balanceFactor(node);
    // hay un desbalance Der-?
    if (bF > 1)
    {
      int bFRight = balanceFactor(node->right);
      // hay un desbalance Der-Der
      if (bFRight > 0)
      {
        node = leftRotation(node);
      }
      // hay un desbalance Der-Izq
      if (bFRight < 0)
      {
        node = rightLeftRotation(node);
      }
    }
    // hay un desbalance Izq-?
    if (bF < -1)
    {
      int bFLeft = balanceFactor(node->left);
      // hay un desbalance Izq-Der
      if (bFLeft > 0)
      {
        node = leftRightRotation(node);
      }
      // hay un desbalance Izq-Izq
      if (bFLeft < 0)
      {
        node = rightRotation(node);
      }
    }
    return node;
  }

  AVLNode<T> *insertAux(T data, AVLNode<T> *node)
  {
    if (node == nullptr)
    {
      this->elements++;
      return new AVLNode<T>(data);
    }

    if (data == node->data)
    {
      this->elements++;
      node->count++;
      return node;
    }

    if (data < node->data)
    {
      node->left = insertAux(data, node->left);
    }
    else // if (data > node->data);
    {
      node->right = insertAux(data, node->right);
    }

    node->height = 1 + max(height(node->left), height(node->right));

    node = rebalance(node);

    return node;
  }
  void inOrderLoad(List<T> *l, AVLNode<T> node)
  {
    if (node == nullptr)
    {
      return;
    }
    inOrderLoad(l, node->left);
    l->add(node->data);
    inOrderLoad(l, node->right);
  }

public:
  iterator<T> iterator() override
  {
    List<T> *l = new LinkedList<T>();

    inOrderLoad(l, root);

    return l->iterator();
  }
  void insert(T data) override
  {
    root = insertAux(data, root);
  }

  void remove(T data) override
  {
    root = removeAux(data, root);
  }

  bool contains(T data) override
  {
    return containsAux(data, root);
  }

  T get(T data) override
  {
    // TODO Auto-generated method stub
  }

  T max() override
  {
    return maxAux(root);
  }

  T min() override
  {
    // TODO Auto-generated method stub
  }

  int count() override
  {
    return elements;
  }

  void printInOrder() override
  {
    printInOrderAux(root);
  }
};
