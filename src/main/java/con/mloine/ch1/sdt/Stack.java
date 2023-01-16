package con.mloine.ch1.sdt;

import java.util.Iterator;

/**
 * @Author: mloine
 * @Date: 2023-01-17-01:40
 * @Description: 基于链表实现的栈
 * 1. 所需空间和集合大小成正比
 */
public class Stack<Item> implements Iterable<Item> {

    private Node first;

    private int N;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item result = first.item;
        first = first.next;
        N--;
        return result;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public class Node {

        Item item;
        Node next;

    }
}
