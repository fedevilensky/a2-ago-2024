#pragma once

#include "./list.cpp"
#include <assert.h>

template <class T>
struct LinkedListNode
{
  T data;
  LinkedListNode *next;

  LinkedListNode()
  {
    next = nullptr;
  }

  LinkedListNode(T data)
  {
    this->data = data;
    this->next = nullptr;
  }

  LinkedListNode(T data, LinkedListNode *next)
  {
    this->data = data;
    this->next = next;
  }
};

template <class T>
class LinkedList : public List<T>
{
private:
  int size = 0;
  LinkedListNode<T> *head = nullptr;
  LinkedListNode<T> *tail = nullptr;

public:
  LinkedList()
  {
  }

  int length() override
  {
    return size;
  }

  void add(T data) override
  {
    LinkedListNode<T> *newNode = new LinkedListNode<T>(data);
    if (size == 0)
    {
      this->head = newNode;
      this->tail = newNode;
    }
    else
    {
      tail->next = newNode;
      tail = tail->next;
    }
    size++;
  }

  void remove(T data) override
  {
  }

  void remove() override
  {
  }

  void addFirst(T data) override
  {
    LinkedListNode<T> *newNode = new LinkedListNode<T>(data);
    if (size == 0)
    {
      this->head = newNode;
      this->tail = newNode;
    }
    else
    {
      newNode->next = head;
      head = newNode;
    }
    size++;
  }

  T get(int i) override
  {
    // se rompe si esta fuera de rango
    assert(i < size);
    LinkedListNode<T> *curr = head;
    for (int pos = 0; pos < i; pos++)
    {
      curr = curr->next;
    }
    return curr->data;
  }

  bool contains(T data) override
  {
    LinkedListNode<T> *curr = head;
    while (curr != nullptr)
    {
      if (curr->data == data)
      {
        return true;
      }

      curr = curr->next;
    }
    return false;
  }
};
