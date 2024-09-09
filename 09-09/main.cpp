#include "adts/priority_queue/minHeap.cpp"
#include <iostream>

struct miPrioridad
{
  int a;
  int b;
  int c;

  bool operator<(const miPrioridad &other) const
  {
    if (a > other.a)
    {
      return false;
    }
    else if (a < other.a)
    {
      return true;
    }
    else if (b > other.b)
    {
      return false;
    }
    else if (b < other.b)
    {
      return true;
    }
    else if (c > other.c)
    {
      return false;
    }
    else if (c < other.c)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
};

int main()
{
  priorityQueue<int, miPrioridad> *pq = new minHeap<int, miPrioridad>(10);
  for (int i = 10; i > 0; i--)
  {
    pq->enqueue(i, miPrioridad{i, i - 2, i - 3});
  }

  while (!pq->isEmpty())
  {
    std::cout << pq->dequeue() << std::endl;
  }
}
