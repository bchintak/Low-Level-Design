package com.lru_ttl.model;

import lombok.Data;

@Data
public class Node<K> {

    private final K key;

    private Node<K> prev;
    private Node<K> next;

    public Node(K key) {
        this.key = key;
    }
}