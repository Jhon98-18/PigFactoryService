package com.pj.littlepig.link;

import java.util.Objects;

public class Node<E> {
    Node<E> previous;
    E data;
    Node<E> next;

    public Node(Node<E> previous, E data, Node<E> next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    public Node(E data) {
        this.data = data;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(data, node.data) &&
                Objects.equals(next, node.next);
    }

}
