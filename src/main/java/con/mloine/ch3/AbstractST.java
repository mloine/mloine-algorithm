package con.mloine.ch3;

import java.util.Iterator;

/**
 * @Author: mloine
 * @Date: 2023-02-03-15:46
 * @Description: 符号表的抽象API定义
 */
public abstract class AbstractST<Key, Value> {

    public AbstractST() {
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
     * 表中所有键的集合
     *
     * @return 键集合
     */
    abstract Iterator<Key> keys();
}
