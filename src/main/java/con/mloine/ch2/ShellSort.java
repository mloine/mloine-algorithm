package con.mloine.ch2;

/**
 * @Author: mloine
 * @Date: 2023-01-18-16:50
 * @Description: 希尔排序
 * 1. 在插入排序的基础上 增加移动步长 。达到字数组的有序,大数组局部有序。
 * 2. 不断缩短步长 步长==1 的时候 大数组有序程度较高 可有效加快最后一次插入排序的性能
 * 3. 希尔排序和初级排序相比 可以用于大型数组
 */
public class ShellSort extends BaseSort {
    @Override
    void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;

        // 计算初始步长
        int stepLength = 3;

        while (h < n / stepLength) {
            h = stepLength * h + 1;
        }

        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < n; i++) {
                // 将a[i] 插入到 a[i-h] a[i-2*h] ... 中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / stepLength;
        }
    }
}
