package com.lru_ttl.expiry;

import lombok.Getter;

@Getter
public class ExpiryNode<K> {

    private final K key;

    private final long expiryTime;

    public ExpiryNode(K key,
                      long expiryTime) {

        this.key = key;
        this.expiryTime = expiryTime;
    }

}