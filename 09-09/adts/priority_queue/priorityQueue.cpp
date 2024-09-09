#pragma once

template <class T, class P>
class priorityQueue
{
public:
  virtual void enqueue(T data, P prority) = 0;
  virtual T peek() = 0;
  virtual T dequeue() = 0;
  virtual bool isEmpty() = 0;
  virtual int size() = 0;
  virtual bool isFull() = 0;
};
