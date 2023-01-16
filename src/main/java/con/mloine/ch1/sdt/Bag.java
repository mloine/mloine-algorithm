package con.mloine.ch1.sdt;

import java.util.Iterator;

/**
 * @Author: mloine
 * @Date: 2023-01-17-01:40
 * @Description: 基于链表实现的背包
 * 1. 所需空间和集合大小成正比
 */
public class Bag<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }


    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }


    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class Node {

        Item item;
        Node next;

    }
}
