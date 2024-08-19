#pragma once

template <class T>
class List
{
public:
  virtual void add(T data) = 0;
  virtual void remove(T data) = 0;
  virtual void remove() = 0;
  virtual void addFirst(T data) = 0;
  virtual T get(int i) = 0;
  virtual bool contains(T data) = 0;
  virtual int length() = 0;
};
