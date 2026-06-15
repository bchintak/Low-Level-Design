package com.lru_ttl.policy;

public interface EvictionPolicy<K> {

    void keyAccessed(K key);

    K evictKey();

    void remove(K key);
}