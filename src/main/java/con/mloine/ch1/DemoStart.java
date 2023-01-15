package con.mloine.ch1;

/**
 * @Author: mloine
 * @Date: 2023-01-15-23:33
 * @Description: 最大公约数的自然语言描述: p和q的最大公约数 若q是0,则最大公约数为p。否则将p除以q得到余数r , p和q的最大公约数等于q和r的最大公约数
 */
public class DemoStart {

    /**
     * @param p 整数A
     * @param q 整数B
     * @return A和B的最大公约数
     */
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        System.out.println(gcd(34, 4));
        System.out.println(gcd(34, 6));
    }
}
