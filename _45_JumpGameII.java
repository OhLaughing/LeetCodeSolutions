package LeetCodeSolutions;

public class _45_JumpGameII {
    public int jump(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int range = -1;
        int nextRange = nums[0];
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > range) {
                step++;
                range = nextRange;
            }
            if (nextRange < i + nums[i])
                nextRange = i + nums[i];
        }
        return step;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        _45_JumpGameII ss = new _45_JumpGameII();
        System.out.println(ss.jump(a));
    }
}
