package con.mloine.ch3;

import java.util.Iterator;

/**
 * @Author: mloine
 * @Date: 2023-02-03-15:46
 * @Description: 有序符号表的抽象API定义
 */
public abstract class AbstractSortST<Key extends Comparable<Key>, Value> {

    public AbstractSortST() {
    }

    /**
     * 将键值存入表中
     *
     * @param key   键
     * @param value 值
     */
    abstract void put(Key key, Value value);

    /**
     * 获取键key的对应值
     *
     * @param key 键
     * @return 值
     */
    abstract Value get(Key key);

    /**
     * 从表中删除键key
     *
     * @param key 键
     */
    abstract void delete(Key key);

    /**
     * 键key是否有对应的值
     *
     * @param key 键
     * @return 布尔值
     */
    abstract boolean contains(Key key);

    /**
     * 表是否为空
     *
     * @return 布尔值
     */
    abstract boolean isEmpty();

    /**
     * 表中键的数量
     *
     * @return 表大小
     */
    abstract int size();

    /**
     * 返回最小的键
     *
     * @return 最小的键
     */
    abstract Key min();

    /**
     * 返回最大的键
     *
     * @return 最大的键
     */
    abstract Key max();

    /**
     * 返回小于等key的最大键
     *
     * @param key 键
     * @return 小于等key的最大键
     */
    abstract Key floor(Key key);

    /**
     * 返回大于等key的最小键
     *
     * @param key 键
     * @return 大于等key的最小键
     */
    abstract Key ceiling(Key key);

    /**
     * 返回小于等于key的键的数量
     *
     * @param key 键
     * @return 小于等于key的键的数量
     */
    abstract int rank(Key key);

    /**
     * 返回排名为k的键
     *
     * @param k 排名
     * @return 排名为k的键
     */
    abstract Key select(int k);

    /**
     * 删除最小的键
     */
    abstract void deleteMin();

    /**
     * 删除最大的键
     */
    abstract void deleteMax();

    /**
     * 返回表中[lo ...  hi]之间键的集合 已排序
     *
     * @param lo 开始键
     * @param hi 结束键
     * @return 表中[lo ...  hi]之间键的集合 已排序
     */
    abstract int size(Key lo, Key hi);


    /**
     * [lo ...  hi]之间的表中所有键的集合 已排序
     *
     * @return 键集合
     */
    abstract Iterator<Key> keys(Key lo, Key hi);


    /**
     * 表中所有键的集合 已排序
     *
     * @return 键集合
     */
    abstract Iterator<Key> keys();
}
