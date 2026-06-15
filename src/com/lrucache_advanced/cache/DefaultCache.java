package com.lrucache_advanced.cache;


import com.lrucache_advanced.policy.EvictionPolicy;
import com.lrucache_advanced.storage.Storage;

public class DefaultCache<K,V>
        implements Cache<K,V> {

    private final int capacity;

    private final Storage<K,V> storage;

    private final EvictionPolicy<K> evictionPolicy;

    public DefaultCache(
            int capacity,
            Storage<K,V> storage,
            EvictionPolicy<K> evictionPolicy) {

        this.capacity = capacity;
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    @Override
    public void put(K key, V value) {

        if(storage.contains(key)) {

            storage.add(key,value);

            evictionPolicy.keyAccessed(key);

            return;
        }

        if(storage.size() >= capacity) {

            K evictKey =
                    evictionPolicy.evictKey();

            storage.remove(evictKey);
        }

        storage.add(key,value);

        evictionPolicy.keyAccessed(key);
    }

    @Override
    public V get(K key) {

        if(!storage.contains(key))
            return null;

        evictionPolicy.keyAccessed(key);

        return storage.get(key);
    }
}
