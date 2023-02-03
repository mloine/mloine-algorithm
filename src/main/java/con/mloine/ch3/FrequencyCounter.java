package con.mloine.ch3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: mloine
 * @Date: 2023-02-03-22:17
 * @Description:
 */
public class FrequencyCounter {

    public static void main(String[] args) {
        int minLen = 2;

        AbstractST<String, Integer> st = new BaseST<String, Integer>() {
            @Override
            void put(String s, Integer integer) {

            }

            @Override
            Integer get(String s) {
                return null;
            }

            @Override
            int size() {
                return 0;
            }

            @Override
            Iterator<String> keys() {
                return null;
            }
        };

        List<String> words = prepareWords();

        for (String x : words) {
            if (x.length() < minLen) {
                continue;
            }

            if (!st.contains(x)) {
                st.put(x, 1);
            } else {
                st.put(x, st.get(x) + 1);
            }
        }

        // 找出频率最高的词
        String max = "";
        st.put(max, 0);
        for (Iterator<String> it = st.keys(); it.hasNext(); ) {
            String word = it.next();
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }

        System.out.printf("%s\t%s%n", max, st.get(max));
    }

    private static List<String> prepareWords() {

        String s = """
                hello world my name is Mloine
                """;

        return Arrays.stream(s.split(" ")).toList();
    }
}
