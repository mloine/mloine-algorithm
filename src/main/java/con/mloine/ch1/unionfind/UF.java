package con.mloine.ch1.unionfind;

/**
 * @Author: mloine
 * @Date: 2023-01-17-21:38
 * @Description:
 */
public abstract class UF extends AbstractUF {
    /**
     * 分量id 以触点作为索引
     */
    int[] id;

    /**
     * 分量的数量
     */
    int count;

    public UF(int n) {
        super(n);
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }

    }

    @Override
    void union(int p, int q) {
        //等待具体实现
    }

    @Override
    int find(int p) {
        //等待具体实现
        return 0;
    }

    @Override
    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    int count() {
        return count;
    }


}
