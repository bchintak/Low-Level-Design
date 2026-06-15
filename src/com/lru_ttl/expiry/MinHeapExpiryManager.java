package com.lru_ttl.expiry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinHeapExpiryManager<K>
        implements ExpiryManager<K> {

    private final PriorityQueue<ExpiryNode<K>> minHeap;

    public MinHeapExpiryManager() {

        minHeap =
                new PriorityQueue<>(
                        Comparator.comparingLong(
                                ExpiryNode::getExpiryTime
                        )
                );
    }

    @Override
    public void add(K key,
                    long expiryTime) {

        minHeap.offer(
                new ExpiryNode<>(key, expiryTime)
        );
    }

    @Override
    public List<K> getExpiredKeys() {

        long currentTime =
                System.currentTimeMillis();

        List<K> expiredKeys =
                new ArrayList<>();

        while(!minHeap.isEmpty()
                && minHeap.peek().getExpiryTime()
                <= currentTime) {

            expiredKeys.add(
                    minHeap.poll().getKey()
            );
        }

        return expiredKeys;
    }
}
