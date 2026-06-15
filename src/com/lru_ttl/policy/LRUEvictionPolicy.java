package com.lru_ttl.policy;

import com.lru_ttl.dll.DoublyLinkedList;
import com.lru_ttl.model.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<K>
        implements EvictionPolicy<K> {

    private final DoublyLinkedList<K> dll;

    private final Map<K, Node<K>> nodeMap;

    public LRUEvictionPolicy() {

        dll = new DoublyLinkedList<>();
        nodeMap = new HashMap<>();
    }

    @Override
    public void keyAccessed(K key) {

        if(nodeMap.containsKey(key)) {

            dll.moveToFront(nodeMap.get(key));
            return;
        }

        Node<K> node = new Node<>(key);

        dll.addFirst(node);

        nodeMap.put(key, node);
    }

    @Override
    public K evictKey() {

        Node<K> node = dll.removeLast();

        if(node == null)
            return null;

        nodeMap.remove(node.getKey());

        return node.getKey();
    }

    @Override
    public void remove(K key) {

        Node<K> node = nodeMap.get(key);

        if(node == null) {
            return;
        }

        dll.remove(node);

        nodeMap.remove(key);
    }
}