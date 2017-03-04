package LeetCodeSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _89_GrayCode {

    public List<Integer> grayCode(int n) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(0));
        } else {
            List<Integer> list = grayCode(n - 1);
            List<Integer> cur = new ArrayList<>(list);

            for (int i = list.size() - 1; i >= 0; i--) {
                cur.add((1 << (n - 1)) + list.get(i));
            }
            return cur;
        }
    }

    public static void main(String[] args) {
        _89_GrayCode ss = new _89_GrayCode();
        System.out.println(ss.grayCode(2));
        System.out.println(1 << 2);
    }
}
