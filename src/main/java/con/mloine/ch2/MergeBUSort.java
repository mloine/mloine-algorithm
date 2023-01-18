package con.mloine.ch2;

/**
 * @Author: mloine
 * @Date: 2023-01-18-23:04
 * @Description: 归并排序
 * 1. 归并排序的效率达到 线性对谁级别 可用于大量数据的场景
 * 2. 归并排序 包含递归操作。 含有分治思想
 * 3. 自下而上的归并写法
 */
public class MergeBUSort extends MergeBaseSort {

    @Override
    void sort(Comparable[] a) {
        super.sort(a);
        int N = a.length;
        // sz 表示子数组的大小 sz 1 2 4 ...
        for (int sz = 1; sz < N; sz = sz + sz) {
            // 按sz步长分组合并
            for (int lo = 0; lo < (N - sz); lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }

    }
}
