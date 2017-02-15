package LeetCodeSolutions;

import java.util.Arrays;

public class _16_3SumClosest {

    //网上找到的效率比较高的算法
    public int threeSumClosest1(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);

                if (diff == 0) return sum;

                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }


    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return -1;
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int first = i + 1;
            int last = nums.length - 1;
            while (first < last) {
                int sum = nums[i] + nums[first] + nums[last];
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }
                if (sum < target)
                    first++;
                else
                    last--;
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 3, 4, 4, 5, 5};
        _16_3SumClosest solution = new _16_3SumClosest();
        System.out.println(solution.threeSumClosest(a, 10));

    }
}



