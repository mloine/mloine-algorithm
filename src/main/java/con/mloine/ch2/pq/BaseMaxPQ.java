package con.mloine.ch2.pq;

/**
 * @Author: mloine
 * @Date: 2023-01-20-00:04
 * @Description: 基础实现 只实现通用的优先队列API
 * 1. 使用数组实现的堆 下标从1开始
 * 2. 插入元素 和 删除最大元素 都是 对数级别效率
 */
public class BaseMaxPQ<Key extends Comparable<Key>> extends AbstractMaxPQ<Key> {

    /**
     * 数组表示堆
     */
    Key[] pq;

    /**
     * 当前堆大小
     */
    int N = 0;

    public BaseMaxPQ() {
        super();
    }

    public BaseMaxPQ(int max) {
        super(max);
        pq = (Key[]) new Comparable[max + 1];
    }

    public BaseMaxPQ(Key[] a) {
        super(a);
    }

    @Override
    void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    @Override
    Key max() {
        return pq[1];
    }

    @Override
    Key delMax() {
        // 获取头部元素
        Key max = pq[1];
        // 移动尾部元素到头部
        exch(1, N--);
        //清理空间
        pq[N + 1] = null;
        // 下沉头部元素 恢复堆的有序性
        sink(1);
        return max;
    }

    @Override
    boolean isEmpty() {
        return N == 0;
    }

    @Override
    int size() {
        return N;
    }


    /**
     * 比较两个元素的大小
     * v > w ?
     *
     * @param v 比较元素v 下标
     * @param w 比较元素w 下标
     * @return 布尔值
     */
    private boolean less(int v, int w) {
        return pq[v].compareTo(pq[w]) < 0;
    }

    /**
     * 交换两个元素的位置
     *
     * @param i 元素下标a
     * @param j 元素下标b
     */
    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }


    /**
     * 堆 由下至上的上浮操作
     *
     * @param k 上浮元素下标
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 堆 由上至下的下浮操作
     *
     * @param k 下浮元素的下标
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }

            if (!less(k, j)) {
                break;
            }

            exch(k, j);
            k = j;
        }

    }


}
