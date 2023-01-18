package con.mloine.ch2;

/**
 * @Author: mloine
 * @Date: 2023-01-18-16:50
 * @Description: 插入排序
 */
public class InsertionSort extends BaseSort {
    @Override
    void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            // 将a[i] 插入到 a[i-1] a[i-2] ... a[0]中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
}
