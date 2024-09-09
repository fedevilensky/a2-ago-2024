#pragma once

#include "priorityQueue.cpp"
#include "../pair.cpp"
#include <assert.h>

template <class T, class P>
class minHeap : public priorityQueue<T, P>
{
private:
  pair<T, P> *arr;
  int arrSize;
  int elements;

  void siftUp(int pos)
  {
    if (pos == 1)
    {
      return;
    }

    int parent = getParent(pos);

    if (arr[pos].snd < arr[parent].snd)
    {
      swap(pos, parent);
      siftUp(parent);
    }
  }

  int getParent(int pos)
  {
    return pos / 2;
  }

  void swap(int pos1, int pos2)
  {
    pair<T, P> aux = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = aux;
  }

public:
  minHeap(int expectedSize)
  {
    arr = new pair<T, P>[expectedSize + 1];
    arrSize = expectedSize;
    elements = 0;
  }

  virtual void enqueue(T data, P prority) override
  {
    assert(!isFull());

    elements++;
    arr[elements] = pair<T, P>(data, prority);
    siftUp(elements);
  }
  virtual T peek() override
  {
    assert(false);
  }
  virtual T dequeue() override
  {
    assert(false);
  }
  virtual bool isEmpty() override
  {
    assert(false);
  }
  virtual int size() override
  {
    assert(false);
  }
  virtual bool isFull() override
  {
    assert(false);
  }
};
