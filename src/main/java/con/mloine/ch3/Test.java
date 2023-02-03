package con.mloine.ch3;

import java.util.Iterator;

/**
 * @Author: mloine
 * @Date: 2023-02-03-22:05
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        AbstractST<String, Integer> st;
        st = new BaseST<String, Integer>() {
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

        char[] chars = "SEARCHEXAMPLE".toCharArray();
        for (int i = 0; i < chars.length; i++) {
            st.put(String.valueOf(chars[i]), i);
        }

        for (Iterator<String> it = st.keys(); it.hasNext(); ) {
            String key = it.next();
            System.out.printf("%s\t%s%n", key, st.get(key));
        }

    }
}
