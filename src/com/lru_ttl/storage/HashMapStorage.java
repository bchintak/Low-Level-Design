package com.lru_ttl.storage;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<K,V>
        implements Storage<K,V> {

    private final Map<K,V> map;

    public HashMapStorage() {
        this.map = new HashMap<>();
    }

    @Override
    public void put(K key, V value) {
        map.put(key, value);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public void remove(K key) {
        map.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return map.containsKey(key);
    }

    @Override
    public int size() {
        return map.size();
    }
}