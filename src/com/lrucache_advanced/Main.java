package com.lrucache_advanced;

import com.lrucache_advanced.cache.DefaultCache;
import com.lrucache_advanced.policy.LRUEvictionPolicy;
import com.lrucache_advanced.storage.HashMapStorage;

public class Main {

    public static void main(String[] args) {

        DefaultCache<Integer,String> cache =
                new DefaultCache<>(
                        3,
                        new HashMapStorage<>(),
                        new LRUEvictionPolicy<>()
                );

        cache.put(1,"A");
        cache.put(2,"B");
        cache.put(3,"C");

        cache.get(1);

        cache.put(4,"D");

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
