package con.mloine.ch2;

/**
 * @Author: mloine
 * @Date: 2023-01-18-23:04
 * @Description: 归并排序
 * 1. 归并排序的效率达到 线性对谁级别 可用于大量数据的场景
 * 2. 归并排序 包含递归操作。 含有分治思想
 * 3. 自上而下的归并写法
 */
public class MergeSort extends MergeBaseSort {

    @Override
    void sort(Comparable[] a) {
        super.sort(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        // 左半边排序
        sort(a, lo, mid);
        // 右半边排序
        sort(a, mid + 1, hi);
        // 归并左右数组
        merge(a, lo, mid, hi);
    }
}
