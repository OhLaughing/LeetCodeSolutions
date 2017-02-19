package LeetCodeSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gustaov on 2017/2/16.
 */
public class _18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int thrid = j + 1;
                int forth = nums.length - 1;
                while (thrid < forth) {
                    int sum = nums[i] + nums[j] + nums[thrid] + nums[forth];
                    if (sum == target) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[thrid]);
                        tempList.add(nums[forth]);
                        result.add(tempList);
                        thrid++;
                        forth--;

                        while (thrid < forth && nums[thrid] == nums[thrid - 1])
                            thrid++;
                        while (thrid < forth && nums[forth] == nums[forth + 1])
                            forth--;
                    } else if (sum < target)
                        thrid++;
                    else
                        forth--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 0, 0};
        _18_4Sum solution = new _18_4Sum();
        System.out.println(solution.fourSum(a, 0));
    }
}
