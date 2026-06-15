package com.lru_ttl.model;

import lombok.Getter;

@Getter
public class CacheEntry<V> {

    private final V value;
    private final long expiryTime;

    public CacheEntry(V value, long expiryTime) {
        this.value = value;
        this.expiryTime = expiryTime;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }
}