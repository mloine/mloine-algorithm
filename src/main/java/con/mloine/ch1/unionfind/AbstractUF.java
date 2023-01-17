package con.mloine.ch1.unionfind;

/**
 * @Author: mloine
 * @Date: 2023-01-17-21:27
 * @Description: union-find 算法抽象API
 */
public abstract class AbstractUF {

    /**
     * 初始化 有n个触点的分量
     *
     * @param n
     */
    public AbstractUF(int n) {

    }

    /**
     * 再 p 和 q之间 连接一条线
     * 如果 p q 不在同一个分量则归并两个分量
     * @param p
     * @param q
     */
    abstract void union(int p, int q);

    /**
     * p 在 0-N-1所在分量的标识符号
     *
     * @param p
     * @return
     */
    abstract int find(int p);

    /**
     * 判断p q是否处在同一个分量重
     *
     * @param p
     * @param q
     * @return
     */
    abstract boolean connected(int p, int q);

    /**
     * 返回联通分量的数量
     *
     * @return
     */
    abstract int count();
}
