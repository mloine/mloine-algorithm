package con.mloine.ch1.sdt;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @Author: mloine
 * @Date: 2023-01-16-23:29
 * @Description: 定容栈
 * 1.避免栈溢出 具备扩缩容机制
 * 2.避免游离对象 即时回收数组内存
 * 3.提供迭代能力 可用于foreach写法
 */
public class FixedCapacityStack<Item> implements Iterable<Item> {

    private Item[] a;

    private int N;

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    private FixedCapacityStack() {
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Item pop() {
        if (N > 0 && N == a.length / 4) {
            reSize(a.length / 2);
        }
        int index = --N;
        Item result = a[index];
        a[index] = null;
        return result;
    }

    public void push(Item item) {
        if (N == a.length) {
            reSize(a.length * 2);
        }
        a[N++] = item;
    }

    public void reSize(int max) {
        Item[] tmp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            tmp[i] = a[i];
        }

        a = tmp;
    }

    @Override
    public String toString() {
        return "FixedCapacityStack{" +
                "a=" + Arrays.toString(a) +
                ", N=" + N +
                '}';
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    /**
     * 内部类 帮助完成迭代能力
     */
    public class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> s = new FixedCapacityStack<String>(5);
        s.push("a");
        s.push("b");
        s.push("c");
        s.push("d");
        s.push("e");
        s.push("f");
        s.push("g");
        System.out.println(s);

        System.out.println(s.pop());
        System.out.println(s);
        System.out.println("iterator foreach");
        for (String x : s) {
            System.out.println(x);
        }
        // lambda 表达式
        System.out.println("lambda 表达式");
        s.forEach(System.out::println);
    }


}
