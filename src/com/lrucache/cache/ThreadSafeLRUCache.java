package com.lrucache.cache;

import com.lrucache.dll.DoublyLinkedList;
import com.lrucache.model.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeLRUCache<K, V> implements Cache<K, V> {

    private final int capacity;

    private final Map<K, Node<K, V>> cache;

    private final DoublyLinkedList<K, V> dll;

    private final ReentrantLock lock;

    public ThreadSafeLRUCache(int capacity) {

        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.dll = new DoublyLinkedList<>();
        this.lock = new ReentrantLock();
    }

    @Override
    public V get(K key) {

        lock.lock();

        try {

            Node<K, V> node = cache.get(key);

            if (node == null) {
                return null;
            }

            dll.moveToFront(node);

            return node.getValue();

        } finally {
            lock.unlock();
        }
    }

    @Override
    public void put(K key, V value) {

        lock.lock();

        try {

            Node<K, V> existingNode = cache.get(key);

            if (existingNode != null) {

                existingNode.setValue(value);

                dll.moveToFront(existingNode);

                return;
            }

            if (cache.size() >= capacity) {

                Node<K, V> lruNode = dll.removeLast();

                if (lruNode != null) {
                    cache.remove(lruNode.getKey());
                }
            }

            Node<K, V> newNode = new Node<>(key, value);

            dll.addFirst(newNode);

            cache.put(key, newNode);

        } finally {
            lock.unlock();
        }
    }
}