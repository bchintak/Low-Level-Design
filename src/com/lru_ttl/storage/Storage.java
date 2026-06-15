package com.lru_ttl.storage;

public interface Storage<K,V> {

    void put(K key, V value);

    V get(K key);

    void remove(K key);

    boolean contains(K key);

    int size();
}