#pragma once

template <class T> class iterator {
public:
  virtual T next() = 0;
  virtual bool hasNext() = 0;
};

template <class T> class iterable {
public:
  virtual iterator<T> *getIterator() = 0;
};
