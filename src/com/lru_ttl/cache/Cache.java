package com.lru_ttl.cache;

public interface Cache<K,V> {

    void put(K key,
             V value,
             long ttlSeconds);

    V get(K key);
}