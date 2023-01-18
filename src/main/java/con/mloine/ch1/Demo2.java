package con.mloine.ch1;

import java.util.Arrays;

/**
 * @Author: mloine
 * @Date: 2023-01-15-23:58
 * @Description: 二分查找
 */
public class Demo2 {

    /**
     * @param key 输入数字
     * @param a   查询数组要求实现完成排序 ASC升序
     * @return 命中元素的数组下标
     */
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < key) {
                lo = mid + 1;
            } else if (a[mid] > key) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        Arrays.sort(a);
        System.out.println(rank(4, a));

//        System.out.println(1.0/0.0);
//        System.out.println(Math.abs(-2147483648));
    }
}
