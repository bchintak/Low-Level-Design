package com.lru_ttl;

import com.lru_ttl.cache.DefaultCache;
import com.lru_ttl.expiry.MinHeapExpiryManager;
import com.lru_ttl.model.CacheEntry;
import com.lru_ttl.policy.LRUEvictionPolicy;
import com.lru_ttl.storage.HashMapStorage;

public class Main {

    public static void main(String[] args)
            throws Exception {

        DefaultCache<String,String> cache =
                new DefaultCache<>(
                        3,
                        new HashMapStorage<String,
                                CacheEntry<String>>(),
                        new LRUEvictionPolicy<>(),
                        new MinHeapExpiryManager<>()
                );

        cache.put("A","Apple",5);
        cache.put("B","Ball",10);
        cache.put("C","Cat",15);

        System.out.println(cache.get("A"));

        Thread.sleep(6000);

        System.out.println(cache.get("A"));

        cache.put("D","Dog",20);

        System.out.println(cache.get("B"));
        System.out.println(cache.get("C"));
        System.out.println(cache.get("D"));
    }
}