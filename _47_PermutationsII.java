package LeetCodeSolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gustaov on 2017/2/26.
 */
public class _47_PermutationsII {
    List<List<Integer>> result;

    public List<List<Integer>> permteUnique(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0);
        return result;
    }

    private void helper(int[] nums, int i) {
        if (i == nums.length) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                l.add(nums[j]);
            }
            result.add(l);
        } else {
            for (int j = i; j < nums.length; j++) {
                if(isContainDuplicate(nums,i,j)) {
                    swap(nums, i, j);
                    helper(nums, i + 1);
                    swap(nums, i, j);
                }
            }
        }
    }

    private boolean isContainDuplicate(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if(nums[i] == nums[end])
                return false;
        }
        return true;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2,2};
        _47_PermutationsII ss = new _47_PermutationsII();
        System.out.println(ss.permteUnique(a));
    }
}
