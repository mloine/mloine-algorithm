package con.mloine.ch3;

import con.mloine.ch2.AbstractSort;

import java.util.Iterator;

/**
 * @Author: mloine
 * @Date: 2023-02-03-15:46
 * @Description: 符号表公共方法实现
 */
public abstract class BaseSortST<Key extends Comparable<Key>, Value> extends AbstractSortST<Key, Value> {

    public BaseSortST() {
    }


    /**
     * 从表中删除键key
     *
     * @param key 键
     */
    void delete(Key key) {
        put(key, null);
    }

    /**
     * 键key是否有对应的值
     *
     * @param key 键
     * @return 布尔值
     */
    boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * 表是否为空
     *
     * @return 布尔值
     */
    boolean isEmpty() {
        return size() == 0;
    }


    @Override
    void deleteMin() {
        put(min(), null);
    }

    @Override
    void deleteMax() {
        put(max(), null);
    }

    @Override
    int size(Key lo, Key hi) {
        if (hi.compareTo(lo) < 0) {
            return 0;
        } else if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }

    }

    @Override
    Iterator<Key> keys() {
        return keys(min(), max());
    }


}
