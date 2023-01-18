package con.mloine.ch2;

/**
 * @Author: mloine
 * @Date: 2023-01-18-15:29
 * @Description: 实现排序的基础API 除了sort方法
 */
public class BaseSort extends AbstractSort {

    @Override
    void sort(Comparable[] a) {
        //   this is empty implement function
    }

    /**
     * 比较两个元素的大小
     * v > w ?
     *
     * @param v 比较元素v
     * @param w 比较元素w
     * @return 布尔值
     */
    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换两个元素的位置
     *
     * @param a 目标数组
     * @param i 元素下标a
     * @param j 元素下标b
     */
    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 输出数组内容
     *
     * @param a 目标数组
     */
    public void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%s\t", a[i]);
        }
        System.out.println();
    }


    /**
     * 判断元素是否有序
     *
     * @param a 目标数组
     * @return 布尔值
     */
    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            // a[i-1] < a[i]
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }


}
