package LeetCodeSolutions;

import java.util.ArrayList;
import java.util.List;

public class _77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(result, temp, n, k, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> temp, int n, int k, int index) {
        if (temp.size() == k) {
            List<Integer> list = new ArrayList<>(temp);
            result.add(list);
        } else {
            for (int i = index; i <n; i++) {
                temp.add(i+1);
                helper(result, temp, n, k, i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        _77_Combinations solution = new _77_Combinations();
        System.out.println(solution.combine(4, 2));
    }
}
