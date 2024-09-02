package adts.maps;

import java.util.Iterator;
import java.util.LinkedList;

import adts.hash.HashFunc;

public class OpenHashMap<K, V> implements Map<K, V> {
    class OpenHashMapPair<K, V> {
        K key;
        V value;

        @Override
        public boolean equals(Object o) {
            OpenHashMapPair<K, V> other = (OpenHashMapPair<K, V>) o;
            return other.key.equals(key);
        }

        public OpenHashMapPair(K key) {
            this.key = key;
        }

        public OpenHashMapPair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /***
     * buckets es LinkedList[OpenHashMapPair[K,V]]
     */
    private Object[] buckets;
    int elements = 0;
    private HashFunc<K> h;

    private int abs(int x) {
        if (x < 0) {
            return -x;
        }
        return x;
    }

    public OpenHashMap(HashFunc<K> h, int expectedSize) {
        this.h = h;
        this.buckets = new Object[expectedSize * 2 - 1];
    }

    @Override
    public void insert(K key, V value) {
        int hash = h.hash(key);
        int pos = abs(hash % buckets.length);

        if (buckets[pos] == null) {
            buckets[pos] = new LinkedList<OpenHashMapPair<K, V>>();
        }

        OpenHashMapPair<K, V> pair = new OpenHashMapPair<>(key, value);
        LinkedList<OpenHashMapPair<K, V>> l = (LinkedList<OpenHashMapPair<K, V>>) buckets[pos];
        if (l.contains(pair)) {
            l.remove(pair);
            elements--;
        }
        l.add(pair);
        elements++;
    }

    @Override
    public void remove(K key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean has(K key) {
        int hash = h.hash(key);
        int pos = abs(hash % buckets.length);
        if (buckets[pos] == null) {
            return false;
        }

        OpenHashMapPair<K, V> pair = new OpenHashMapPair<K, V>(key);
        LinkedList<OpenHashMapPair<K, V>> l = (LinkedList<OpenHashMapPair<K, V>>) buckets[pos];

        return l.contains(pair);
    }

    @Override
    public V get(K key) {
        int hash = h.hash(key);
        int pos = abs(hash % buckets.length);
        if (buckets[pos] == null) {
            throw new RuntimeException("Key not found");
        }

        OpenHashMapPair<K, V> pair = new OpenHashMapPair<K, V>(key);
        LinkedList<OpenHashMapPair<K, V>> l = (LinkedList<OpenHashMapPair<K, V>>) buckets[pos];

        // Iterator<OpenHashMapPair<K, V>> it = l.iterator();
        // while(it.hasNext()){
        //  OpenHashMapPair<K,V> currPair = it.next();
        //  if(currPair.equals(pair)){
        //      return currPair.value;
        //  }
        // }
        for (OpenHashMapPair<K, V> currPair : l) {
            if (currPair.equals(pair)) {
                return currPair.value;
            }
        }

        throw new RuntimeException("Key not found");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public Iterable<K> keys() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keys'");
    }

    @Override
    public Iterable<V> values() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'values'");
    }

}
