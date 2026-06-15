package com.lrucache.cache;

import com.lrucache.dll.DoublyLinkedList;
import com.lrucache.model.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> implements Cache<K,V> {

    private final int capacity;

    private final Map<K, Node<K,V>> cache;

    private final DoublyLinkedList<K,V> dll;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.dll = new DoublyLinkedList<>();
    }

    @Override
    public V get(K key) {

        Node<K,V> node = cache.get(key);

        if(node == null)
            return null;

        dll.moveToFront(node);

        return node.getValue();
    }

    @Override
    public void put(K key, V value) {

        Node<K,V> node = cache.get(key);

        if(node != null) {

            node.setValue(value);

            dll.moveToFront(node);

            return;
        }

        if(cache.size() == capacity) {

            Node<K,V> lruNode = dll.removeLast();

            if(lruNode != null)
                cache.remove(lruNode.getKey());
        }

        Node<K,V> newNode = new Node<>(key,value);

        dll.addFirst(newNode);

        cache.put(key,newNode);
    }
}