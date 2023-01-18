package con.mloine.ch2;

/**
 * @Author: mloine
 * @Date: 2023-01-18-16:11
 * @Description: 选择排序实现
 * 1. 交换操作(exch) 执行次数为n次 线性关系 。 所有排序算法中移动次数最少的
 * 2. 运行时间和输入无关 即时数组元素已经排序完成 或 全部一样 或 随机数据 运行时间都一样
 * 3. 比较次数(less) 为平方级别 大数据量下表现不行
 */
public class SelectionSort extends BaseSort {

    @Override
    void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // 将a[i] 和 a[i+1,n-1] 的最小值交换
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }
}
