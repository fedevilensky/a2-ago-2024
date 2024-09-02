#pragma once

#include "map.cpp"
#include "../hash/hashFunc.cpp"
#include <assert.h>

template <class K, class V>
struct openHashMapPair
{
  K key;
  V value;

  bool operator==(openHashMapPair<K, V> o)
  {
    return this->key == o.key;
  }

  openHashMapPair(K key)
  {
    this->key = key;
  }

  openHashMapPair(K key, V value)
  {
    this->key = key;
    this->value = value;
  }
};

template <class K, class V>
class openHashMap : public map<K, V>
{

private:
  // list<openHashMapPair<K,V>>*[]
  list<openHashMapPair<K, V>> **buckets;
  int bucketsCount;
  int elements = 0;
  hashFunc<K> *h;

  int abs(int x)
  {
    if (x < 0)
    {
      return -x;
    }
    return x;
  }

public:
  openHashMap(HashFunc<K> h, int expectedSize)
  {
    this->h = h;
    this->bucketsCount = expectedSize * 2 - 1;
    this->buckets = new list<openHashMapPair<k, V>> *[bucketsCount];
  }

  void insert(K key, V value) override
  {
    int hash = h->hash(key);
    int pos = abs(hash % bucketsCount);

    if (buckets[pos] == nullptr)
    {
      buckets[pos] = new linkedList<openHashMapPair<K, V>>();
    }

    openHashMapPair<K, V> pair = openHashMapPair<K, V>(key, value);
    LinkedList<OpenHashMapPair<K, V>> l = buckets[pos];
    if (l->contains(pair))
    {
      l->remove(pair);
      elements--;
    }
    l->add(pair);
    elements++;
  }

  void remove(K key) override
  {
    // TODO Auto-generated method stub
  }

  bool has(K key) override
  {
    int hash = h->hash(key);
    int pos = abs(hash % bucketsCount);
    if (buckets[pos] == nullptr)
    {
      return false;
    }

    openHashMapPair<K, V> pair = openHashMapPair<K, V>(key);
    linkedList<openHashMapPair<K, V>> l = buckets[pos];

    return l->contains(pair);
  }

  V get(K key) override
  {
    int hash = h->hash(key);
    int pos = abs(hash % bucketsCount);
    assert(buckets[pos] != nullptr);

    openHashMapPair<K, V> pair = openHashMapPair<K, V>(key);
    LinkedList<OpenHashMapPair<K, V>> l = buckets[pos];

    iterator<openHashMapPair<K, V>> it = l->iterator();
    while (it->hasNext())
    {
      openHashMapPair<K, V> currPair = it->next();
      if (currPair == pair)
      {
        return currPair.value;
      }
    }

    assert(false);
  }

  int size() override
  {
    // TODO Auto-generated method stub
  }

  iterable<K> keys() override
  {
    // TODO Auto-generated method stub
  }

  iterable<V> values() override
  {
    // TODO Auto-generated method stub
  }
};
