package con.mloine.ch2;

/**
 * @Author: mloine
 * @Date: 2023-01-18-15:29
 * @Description: 实现归并排序的部分API
 */
public class MergeBaseSort extends BaseSort {

    /**
     * 辅助数组
     */
    static Comparable[] aux;

    @Override
    void sort(Comparable[] a) {
        // 一次性分配空间
        aux = new Comparable[a.length];
    }

    /**
     * 合并两个数组
     *
     * @param a   原数组
     * @param lo  起始位置
     * @param mid 中间位置
     * @param hi  结束位置
     */
    public void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
