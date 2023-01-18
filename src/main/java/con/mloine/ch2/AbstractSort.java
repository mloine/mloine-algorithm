package con.mloine.ch2;

/**
 * @Author: mloine
 * @Date: 2023-01-18-15:29
 * @Description: 定义排序的基础API
 */
public abstract class AbstractSort {

    /**
     * 排序主方法
     *
     * @param a
     */
    abstract void sort(Comparable[] a);

    /**
     * 比较两个元素的大小
     *
     * @param v 比较元素v
     * @param w 比较元素w
     * @return
     */
    public abstract boolean less(Comparable v, Comparable w);

    /**
     * 交换两个元素的位置
     *
     * @param a 目标数组
     * @param i 元素下标a
     * @param j 元素下标b
     */
    public abstract void exch(Comparable[] a, int i, int j);

    /**
     * 输出数组内容
     *
     * @param a 目标数组
     */
    public abstract void show(Comparable[] a);


    /**
     * 判断元素是否有序
     *
     * @param a 目标数组
     * @return
     */
    public abstract boolean isSorted(Comparable[] a);


}
