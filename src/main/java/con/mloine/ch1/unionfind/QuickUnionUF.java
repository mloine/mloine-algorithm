package con.mloine.ch1.unionfind;

/**
 * @Author: mloine
 * @Date: 2023-01-17-22:36
 * @Description: quick-union算法
 * 1.index 下标达标触点标识或当前分量的标识 id[index] 代表一个联通关系 当 index==id[index] 标识找到了当前分量的标识为index
 * 2. union的效率数量级在线性,再最坏的情况下会达到平方级别
 * 3. 此处id数组 包含标识和关系 从最后的关系表示上可以理解是树结构,`最后是一片森林`
 */
public class QuickUnionUF extends UF {

    public QuickUnionUF(int n) {
        super(n);
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
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }
}
