package com.lrucache_advanced.policy;

import com.lrucache_advanced.dll.DoublyLinkedList;
import com.lrucache_advanced.model.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<K>
        implements EvictionPolicy<K> {

    private final DoublyLinkedList<K> dll;

    private final Map<K, Node<K>> nodeMap;

    public LRUEvictionPolicy() {

        this.dll = new DoublyLinkedList<>();
        this.nodeMap = new HashMap<>();
    }

    @Override
    public void keyAccessed(K key) {

        if(nodeMap.containsKey(key)) {

            Node<K> node = nodeMap.get(key);

            dll.moveToFront(node);

            return;
        }

        Node<K> node = new Node<>(key);

        dll.addFirst(node);

        nodeMap.put(key,node);
    }

    @Override
    public K evictKey() {

        Node<K> node = dll.removeLast();

        if(node == null)
            return null;

        nodeMap.remove(node.getKey());

        return node.getKey();
    }
}