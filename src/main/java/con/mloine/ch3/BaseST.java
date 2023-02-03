package con.mloine.ch3;

import java.util.Iterator;

/**
 * @Author: mloine
 * @Date: 2023-02-03-15:46
 * @Description: 符号表公共方法实现
 */
public abstract class BaseST<Key, Value> extends AbstractST<Key, Value> {

    public BaseST() {
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


}
