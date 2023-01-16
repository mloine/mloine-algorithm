package con.mloine.ch1.sdt;

/**
 * @Author: mloine
 * @Date: 2023-01-16-23:29
 * @Description: 定容栈
 */
public class FixedCapacityStackOfString {

    private String[] a;

    private int N;

    public FixedCapacityStackOfString(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public String pop() {
        return a[--N];
    }

    public void push(String item) {
        a[++N] = item;
    }
}
