package com.lrucache_advanced.storage;

import com.lrucache_advanced.storage.Storage;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<K,V>
        implements Storage<K,V> {

    private final Map<K,V> storage;

    public HashMapStorage() {
        this.storage = new HashMap<>();
    }

    @Override
    public void add(K key, V value) {
        storage.put(key,value);
    }

    @Override
    public V get(K key) {
        return storage.get(key);
    }

    @Override
    public void remove(K key) {
        storage.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return storage.containsKey(key);
    }

    @Override
    public int size() {
        return storage.size();
    }
}