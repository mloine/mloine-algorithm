package con.mloine.ch2;

import con.mloine.util.StopWatch;

import java.util.HashMap;
import java.util.Random;
import java.util.function.Consumer;

/**
 * @Author: mloine
 * @Date: 2023-01-18-20:11
 * @Description:
 */
public class SortCompare {

    static HashMap<String, SortConsumer> operations = new HashMap<>() {{
        put("Selection", new SortConsumer(new SelectionSort()));
        put("Insertion", new SortConsumer(new InsertionSort()));
    }};


    public SortCompare() {

    }

    public static class SortConsumer implements Consumer<Comparable[]> {

        AbstractSort abstractSort;

        public SortConsumer(AbstractSort tmp) {
            abstractSort = tmp;
        }

        @Override
        public void accept(Comparable[] a) {
            abstractSort.sort(a);
        }
    }

    public static double time(String alg, Comparable[] a) {

        if (!operations.containsKey(alg)) {
            return 0;
        }
        StopWatch stopWatch = new StopWatch();
        operations.get(alg).accept(a);
        return stopWatch.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        Random random = new Random(100);

        for (int j = 0; j < T; j++) {
            for (int i = 0; i < N; i++) {
                a[i] = random.nextDouble();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {

        String alg1 = "Selection";
        String alg2 = "Insertion";
        int N = 10000;
        int T = 100;

        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        System.out.printf("%s cost %.5f%n", alg1, t1);
        System.out.printf("%s cost %.5f%n", alg2, t2);
        System.out.printf("For %d random Doubles\n %s is ", N, alg1);
        System.out.printf("%.2f times faster than %s\n", t2 / t1, alg2);


    }
}
