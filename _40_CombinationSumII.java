package LeetCodeSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        helper(candidates, target, 0, 0, temp, result);
        return result;
    }

    private void helper(int[] candidates, int target, int sum, int index, List<Integer> temp, List<List<Integer>> result) {
        if (sum == target) {
            List<Integer> list = new ArrayList<>(temp);
            result.add(list);
        } else if (sum < target) {
            for (int i = index; i < candidates.length; i++) {
                if(i!=index&&candidates[i] ==candidates[i-1])
                    continue;
                temp.add(candidates[i]);
                sum += candidates[i];
                helper(candidates, target, sum, i + 1, temp, result);
                temp.remove(temp.size() - 1);
                sum -= candidates[i];
            }
        }
    }

    public static void main(String[] args) {
        int[]a ={10, 1, 2, 7, 6, 1, 5};
        _40_CombinationSumII ss = new _40_CombinationSumII();
        System.out.println(ss.combinationSum2(a,8));
    }
}
