package con.mloine.ch2.pq;

/**
 * @Author: mloine
 * @Date: 2023-01-20-00:04
 * @Description: 基础实现 只实现通用的优先队列API
 */
public class BaseMaxPQ<Key extends Comparable<Key>> extends AbstractMaxPQ<Key> {

    public BaseMaxPQ() {
        super();
    }

    public BaseMaxPQ(int max) {
        super(max);
    }

    public BaseMaxPQ(Key[] a) {
        super(a);
    }

    @Override
    void insert(Key v) {

    }

    @Override
    Key max() {
        return null;
    }

    @Override
    Key delMax() {
        return null;
    }

    @Override
    boolean isEmpty() {
        return false;
    }

    @Override
    int size() {
        return 0;
    }
}
