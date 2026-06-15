package com.lru_ttl.expiry;

import java.util.List;

public interface ExpiryManager<K> {

    void add(K key, long expiryTime);

    List<K> getExpiredKeys();
}
