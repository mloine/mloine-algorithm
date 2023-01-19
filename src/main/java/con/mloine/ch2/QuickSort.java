package con.mloine.ch2;

/**
 * @Author: mloine
 * @Date: 2023-01-19-20:34
 * @Description: 快速排序
 * 1. 分治思想 先数据处理再递归
 * 2. 重点是切分函数 partition 的实现
 */
public class QuickSort extends BaseSort {

    @Override
    void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }


    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * 切分
     *
     * @param a  原数组
     * @param lo 起始位
     * @param hi 结束位
     * @return 切分元素的下标
     */
    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        // 切分元素使用lo下标的元素
        Comparable v = a[lo];

        // 左侧小于v的游标i 和 右侧大于v的游标j 不断逼近相遇的过程
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        // 最后调整交换v元素的正确位置到j
        exch(a, lo, j);
        return j;
    }
}
