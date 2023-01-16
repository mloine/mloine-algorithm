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
 * <p>
 * 缺点: pop 和 push 操作会调整数组的大小 这项操作的耗时和栈的大小成正比
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];

    private int N = 0;

    public ResizingArrayStack() {
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Item pop() {

        Item result = a[--N];
        a[N] = null;

        if (N > 0 && N == a.length / 4) {
            reSize(a.length / 2);
        }

        return result;
    }

    public void push(Item item) {
        if (N == a.length) {
            reSize(a.length * 2);
        }
        a[N++] = item;
    }

    private void reSize(int max) {
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
     * 嵌套类 帮助完成迭代能力
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


}
