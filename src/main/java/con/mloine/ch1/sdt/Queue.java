package con.mloine.ch1.sdt;

import java.util.Iterator;

/**
 * @Author: mloine
 * @Date: 2023-01-17-01:40
 * @Description: 基于链表实现的队列
 * 1.
 */
public class Queue<Item> implements Iterable<Item> {


    private Node first;
    private Node last;
    private int N;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    /**
     * 入队
     *
     * @param item
     */
    public void enqueue(Item item) {
        Node oldLast = last;

        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    /**
     * 出队
     *
     * @return
     */
    public Item dequeue() {
        Item item = first.item;
        first = first.next;

        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class Node {

        Item item;
        Node next;

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
}
