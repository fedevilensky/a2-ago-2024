#pragma once

template <class T>
class iterable
{
  virtual iterator<T> *iterator() = 0;
};

template <class T>
class iterator
{
  virtual T next() = 0;
  virtual bool hasNext() = 0;
};
