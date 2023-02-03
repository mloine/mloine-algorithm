package con.mloine.ch2;

import con.mloine.ch2.pq.BaseMaxPQ;

/**
 * @Author: mloine
 * @Date: 2023-01-19-20:34
 * @Description: 堆排序
 * 1. 基于优先队列的特性排序
 * 2. 重点是切分函数 partition 的实现
 */
public class HeapSort extends BaseSort {

    @Override
    void sort(Comparable[] a) {

        ////1. 准备 堆有序状态
        //BaseMaxPQ keyBaseMaxPQ = new BaseMaxPQ<>(a.length);
        //for (int i = 0; i < a.length; i++) {
        //    keyBaseMaxPQ.insert(a[i]);
        //}
        //
        ////2. 堆有序 取出元素
        //for (int i = a.length - 1; i >= 0; i--) {
        //    a[i] = keyBaseMaxPQ.delMax();
        //}


        //TODO 程序有BUG
        //1. 准备 堆有序状态
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }

        //2. 使用根元素弹出 再恢复堆有序 做排序动作
        while (N > 1) {
            //这里接收的是下标
            exch(a, 1, N--);
            //这里接收的是逻辑序号
            sink(a, 1, N);
        }
    }


    /**
     * 堆 由上至下的下浮操作
     *
     * @param a 原数组
     * @param k 元素逻辑下标 从1开始
     * @param N 数组大小
     */
    private void sink(Comparable[] a, int k, int N) {

        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a, j, j + 1)) {
                j++;
            }

            if (!less(k, j)) {
                break;
            }

            exch(a, k, j);

            k = j;

        }

    }

    public boolean less(Comparable[] a, int v, int w) {
        return super.less(a[v - 1], a[w - 1]);
    }

    @Override
    public void exch(Comparable[] a, int i, int j) {
        super.exch(a, i - 1, j - 1);
    }
}
