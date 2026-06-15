package com.lrucache.dll;

import com.lrucache.model.Node;

public class DoublyLinkedList<K,V> {

    private final Node<K,V> head;
    private final Node<K,V> tail;

    public DoublyLinkedList() {

        head = new Node<>(null,null);
        tail = new Node<>(null,null);

        head.setNext(tail);
        tail.setPrev(head);
    }

    public void addFirst(Node<K,V> node) {

        Node<K,V> first = head.getNext();

        node.setNext(first);
        node.setPrev(head);

        head.setNext(node);
        first.setPrev(node);
    }

    public void remove(Node<K,V> node) {

        Node<K,V> prev = node.getPrev();
        Node<K,V> next = node.getNext();

        prev.setNext(next);
        next.setPrev(prev);
    }

    public void moveToFront(Node<K,V> node) {

        remove(node);
        addFirst(node);
    }

    public Node<K,V> removeLast() {

        if(head.getNext() == tail)
            return null;

        Node<K,V> lruNode = tail.getPrev();

        remove(lruNode);

        return lruNode;
    }
}