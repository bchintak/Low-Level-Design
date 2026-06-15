package com.lru_ttl.dll;


import com.lru_ttl.model.Node;

public class DoublyLinkedList<K> {

    private final Node<K> head;
    private final Node<K> tail;

    public DoublyLinkedList() {

        head = new Node<>(null);
        tail = new Node<>(null);

        head.setNext(tail);
        tail.setPrev(head);
    }

    public void addFirst(Node<K> node) {

        Node<K> first = head.getNext();

        node.setNext(first);
        node.setPrev(head);

        first.setPrev(node);
        head.setNext(node);
    }

    public void remove(Node<K> node) {

        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }

    public void moveToFront(Node<K> node) {

        remove(node);
        addFirst(node);
    }

    public Node<K> removeLast() {

        if(head.getNext() == tail)
            return null;

        Node<K> node = tail.getPrev();

        remove(node);

        return node;
    }
}
