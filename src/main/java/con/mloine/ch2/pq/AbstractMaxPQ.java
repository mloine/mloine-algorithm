package con.mloine.ch2.pq;

/**
 * @Author: mloine
 * @Date: 2023-01-19-23:53
 * @Description: 优先队列数据结构的API
 */
public abstract class AbstractMaxPQ<Key extends Comparable<Key>> {
    /**
     * 创建一个优先队列
     */
    public AbstractMaxPQ() {
    }

    /**
     * 创建一个初始容量为max的优先队列
     *
     * @param max 初始容量
     */
    public AbstractMaxPQ(int max) {
    }

    /**
     * 用a[]中的元素创建一个优先队列
     *
     * @param a 元素源
     */
    public AbstractMaxPQ(Key[] a) {
    }

    /**
     * 向优先队列中插入一个元素
     *
     * @param v 插入元素
     */
    abstract void insert(Key v);

    /**
     * 返回最大元素
     *
     * @return 最大元素
     */
    abstract Key max();

    /**
     * 从优先队列中删除最大元素并返回
     *
     * @return 最大元素
     */
    abstract Key delMax();

    /**
     * 返回队列是否为空
     *
     * @return 布尔值
     */
    abstract boolean isEmpty();

    /**
     * 返回优先队列的元素个数
     *
     * @return 元素个数
     */
    abstract int size();

}
