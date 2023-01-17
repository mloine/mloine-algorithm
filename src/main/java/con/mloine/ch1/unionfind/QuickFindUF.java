package con.mloine.ch1.unionfind;

/**
 * @Author: mloine
 * @Date: 2023-01-17-22:08
 * @Description: quick-fina算法
 * 1.find操作常数级效率
 * 2.但union操作每次触发归并都会扫描id数组全部数据 效率达到线性级别,结合测试用例输入的数据初始化id大小 可以达到平方级别的效率
 * 在大量数据的情况下表现极差
 */
public class QuickFindUF extends UF {
    public QuickFindUF(int n) {
        super(n);
    }

    @Override
    int find(int p) {
        return id[p];
    }

    @Override
    void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == qId) {
                id[i] = pId;
            }
        }
        count--;
    }
}
