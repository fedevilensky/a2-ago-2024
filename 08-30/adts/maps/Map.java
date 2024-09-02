package adts.maps;

public interface Map<K, V> {
    public void insert(K key, V value);
    public void remove(K key);
    public boolean has(K key);
    public V get(K key);
    public int size();
    public Iterable<K> keys();
    public Iterable<V> values();
}