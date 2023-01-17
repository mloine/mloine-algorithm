package con.mloine.ch1.unionfind;

/**
 * @Author: mloine
 * @Date: 2023-01-17-22:04
 * @Description: union-fina 算法的测试用例
 */
public class Test {

    public static void main(String[] args) {
        // input mock
        int[][] input = {{1, 2}, {3, 4}, {6, 4}, {5, 4}, {5, 6}, {2, 0}, {0, 1}};

        int n = input.length;
        //UF uf = new QuickFindUF(n);
        //UF uf = new QuickUnionUF(n);
        //UF uf = new WeightQuickUnionUF(n);
        UF uf = new ZipWeightQuickUnionUF(n);
        for (int[] ints : input) {
            int p = ints[0];
            int q = ints[1];
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            System.out.printf("%d\t%d%n", p, q);
        }
        System.out.printf("%d\tcomponents%n", uf.count());

        System.out.println("---------------");

        for (int i = 0; i < uf.id.length; i++) {
            System.out.printf("index:%d\ttarget:%d%n", i, uf.id[i]);
        }
    }
}
