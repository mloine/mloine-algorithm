package con.mloine.ch2.pq;

import java.util.Random;
import java.util.Stack;

/**
 * @Author: mloine
 * @Date: 2023-01-20-00:05
 * @Description: 测试用例 min M
 */
public class TestTopM {
    public static void main(String[] args) {
        Random rd = new Random();
        int M = 10;
        int inputLine = 10000;
        AbstractMaxPQ<Double> pg = new BaseMaxPQ<Double>(M + 1);

        for (int i = 0; i < inputLine; i++) {
            pg.insert(rd.nextDouble(100));
            if (pg.size() > M) {
                pg.delMax();
            }
        }

        // 
        Stack<Double> stack = new Stack<>();
        while (!pg.isEmpty()) {
            stack.push(pg.delMax());
        }

        stack.forEach(System.out::println);
    }
}
