#pragma once

template <class K, class V>
class map
{
public:
  virtual void insert(K key, V value) = 0;
  virtual void remove(K key) = 0;
  virtual bool has(K key) = 0;
  virtual V get(K key) = 0;
  virtual int size() = 0;
  virtual Iterable<K> keys() = 0;
  virtual Iterable<V> values() = 0;
};
