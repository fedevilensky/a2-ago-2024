#pragma once

#include "../iterator/iterable.cpp"

template <class T>
class bst : iterable<T>
{
public:
    virtual void insert(T data) = 0;
    virtual void remove(T data) = 0;
    virtual bool contains(T data) = 0;
    virtual T get(T data) = 0;
    virtual T max() = 0;
    virtual T min() = 0;
    virtual int count() = 0;
    virtual void printInOrder() = 0;
};
