package con.mloine.ch2;


/**
 * @Author: mloine
 * @Date: 2023-01-18-15:41
 * @Description: 排序测试类
 * 1.注意断言默认是不开启的需要 需要添加vm option：-ea 开启
 * 2. 通过改变AbstractSort的不同子类 来切换不同算法
 */
public class Test {
    public static void main(String[] args) {

        String[] a = {"a", "c", "b", "c", "shell", "mloine", "hdfs", "java", "python", "golang", "ts", "jq", "js", "vue", "react"};

        AbstractSort st;

        //st = new SelectionSort();
        //st = new InsertionSort();
        //st = new ShellSort();
        //st = new MergeSort();
        //st = new MergeBUSort();
        st = new QuickSort();

        st.sort(a);
        st.show(a);

        assert st.isSorted(a);

        st.show(a);

    }
}
