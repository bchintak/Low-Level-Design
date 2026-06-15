package com.lru_ttl.cache;

import com.lru_ttl.expiry.ExpiryManager;
import com.lru_ttl.model.CacheEntry;
import com.lru_ttl.policy.EvictionPolicy;
import com.lru_ttl.storage.Storage;

import java.util.List;

public class DefaultCache<K,V>
        implements Cache<K,V> {

    private final int capacity;

    private final Storage<K,
            CacheEntry<V>> storage;

    private final EvictionPolicy<K> evictionPolicy;

    private final ExpiryManager<K> expiryManager;

    public DefaultCache(
            int capacity,
            Storage<K, CacheEntry<V>> storage,
            EvictionPolicy<K> evictionPolicy,
            ExpiryManager<K> expiryManager) {

        this.capacity = capacity;
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
        this.expiryManager = expiryManager;
    }

    private void cleanExpiredKeys() {

        List<K> expiredKeys =
                expiryManager.getExpiredKeys();

        for(K key : expiredKeys) {

            storage.remove(key);
            evictionPolicy.remove(key);

        }
    }

    @Override
    public void put(K key,
                    V value,
                    long ttlSeconds) {

        cleanExpiredKeys();

        if(storage.size() >= capacity) {

            K evictKey =
                    evictionPolicy.evictKey();

            if(evictKey != null) {
                storage.remove(evictKey);
            }
        }

        long expiryTime =
                System.currentTimeMillis()
                        + ttlSeconds * 1000;

        CacheEntry<V> entry =
                new CacheEntry<>(
                        value,
                        expiryTime
                );

        storage.put(key, entry);

        evictionPolicy.keyAccessed(key);

        expiryManager.add(
                key,
                expiryTime
        );
    }

    @Override
    public V get(K key) {

        cleanExpiredKeys();

        CacheEntry<V> entry =
                storage.get(key);

        if(entry == null)
            return null;

        if(entry.isExpired()) {

            storage.remove(key);

            return null;
        }

        evictionPolicy.keyAccessed(key);

        return entry.getValue();
    }
}