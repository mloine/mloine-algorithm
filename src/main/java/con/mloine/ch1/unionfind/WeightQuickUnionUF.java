package con.mloine.ch1.unionfind;

/**
 * @Author: mloine
 * @Date: 2023-01-17-22:36
 * @Description: 加权quick-union算法
 * 1.index 下标达标触点标识或当前分量的标识 id[index] 代表一个联通关系 当 index==id[index] 标识找到了当前分量的标识为index
 * 2. 再union操作时候 保证小树连接到大树上 避免增加合并后树的深度 .在最坏的情况下 合并后的树深度总是相同的 效率能达到对数级别
 */
public class WeightQuickUnionUF extends UF {

    /**
     * 各个节点所对应的分量大小
     */
    int[] sz;

    public WeightQuickUnionUF(int n) {
        super(n);
        sz = new int[n];
        for (int i = 0; i < id.length; i++) {
            sz[i] = 1;
        }
    }

    @Override
    int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }

        // 将小树的根节点连接到大树 并增加最后树的分量大小
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }

        count--;
    }
}
