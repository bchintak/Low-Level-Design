package com.lrucache_advanced.model;

import lombok.Data;

@Data
public class Node<K> {

    private K key;

    private Node<K> prev;
    private Node<K> next;

    public Node(K key) {
        this.key = key;
    }
}

