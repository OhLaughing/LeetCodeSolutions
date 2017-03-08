package LeetCodeSolutions;

public class _55_JumpGame {
    public boolean canJump(int[] nums) {
        int reach = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= reach) {
                reach = i;
            }
        }
        return reach == 0;
    }

//    private boolean helper(int[] nums, boolean[] visited, int i) {
//        if (i == nums.length - 1)
//            return true;
//        if (visited[i] == true)
//            return false;
//        boolean b1 = false;
//        boolean b2 = false;
//        visited[i] = true;
//        if (i - nums[i] >= 0)
//            b1 = helper(nums, visited, i - nums[i]);
//
//        if (i + nums[i] < nums.length)
//            b2 = helper(nums, visited, i + nums[i]);
//        visited[i] = false;
//        return b1 || b2;
//    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 0, 4};
        _55_JumpGame ss = new _55_JumpGame();
        System.out.println(ss.canJump(a));
    }
}
