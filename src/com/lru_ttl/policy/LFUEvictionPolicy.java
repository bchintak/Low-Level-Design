package com.lru_ttl.policy;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUEvictionPolicy<K>
        implements EvictionPolicy<K> {

    private final Map<K, Integer> keyFrequencyMap;

    private final Map<Integer,
            LinkedHashSet<K>> frequencyKeysMap;

    private int minFrequency;

    public LFUEvictionPolicy() {

        this.keyFrequencyMap = new HashMap<>();
        this.frequencyKeysMap = new HashMap<>();
        this.minFrequency = 0;
    }

    @Override
    public void keyAccessed(K key) {

        if(!keyFrequencyMap.containsKey(key)) {

            keyFrequencyMap.put(key, 1);

            frequencyKeysMap
                    .computeIfAbsent(
                            1,
                            f -> new LinkedHashSet<>())
                    .add(key);

            minFrequency = 1;

            return;
        }

        int currentFrequency =
                keyFrequencyMap.get(key);

        int newFrequency =
                currentFrequency + 1;

        keyFrequencyMap.put(
                key,
                newFrequency
        );

        LinkedHashSet<K> currentBucket =
                frequencyKeysMap.get(
                        currentFrequency
                );

        currentBucket.remove(key);

        if(currentBucket.isEmpty()) {

            frequencyKeysMap.remove(
                    currentFrequency
            );

            if(minFrequency ==
                    currentFrequency) {

                minFrequency++;
            }
        }

        frequencyKeysMap
                .computeIfAbsent(
                        newFrequency,
                        f -> new LinkedHashSet<>())
                .add(key);
    }

    @Override
    public K evictKey() {

        LinkedHashSet<K> bucket =
                frequencyKeysMap.get(
                        minFrequency
                );

        K key = bucket.iterator().next();

        bucket.remove(key);

        if(bucket.isEmpty()) {

            frequencyKeysMap.remove(
                    minFrequency
            );
        }

        keyFrequencyMap.remove(key);

        return key;
    }

    @Override
    public void remove(K key) {

        Integer frequency =
                keyFrequencyMap.get(key);

        if(frequency == null)
            return;

        LinkedHashSet<K> bucket =
                frequencyKeysMap.get(
                        frequency
                );

        bucket.remove(key);

        if(bucket.isEmpty()) {

            frequencyKeysMap.remove(
                    frequency
            );

            if(minFrequency ==
                    frequency) {

                minFrequency = 0;
            }
        }

        keyFrequencyMap.remove(key);
    }
}