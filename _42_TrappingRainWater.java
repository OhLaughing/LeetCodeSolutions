package LeetCodeSolutions;

public class _42_TrappingRainWater {
    public int trap(int[] height) {
        if (height.length <= 2)
            return 0;
        int leftHeight = 0;
        int rightHeight = 0;
        int curHeight = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int trapWater = 0;
        while (leftIndex <= rightIndex) {
            if (leftHeight <= rightHeight) {
                if (height[leftIndex] < curHeight)
                    trapWater += curHeight - height[leftIndex];
                else if (height[leftIndex] > curHeight) {
                    leftHeight = height[leftIndex];
                }
                leftIndex++;
            } else {
                if (height[rightIndex] < curHeight) {
                    trapWater += curHeight - height[rightIndex];
                } else if (height[rightIndex] > curHeight) {
                    rightHeight = height[rightIndex];
                }
                rightIndex--;
            }
            curHeight = Math.min(leftHeight, rightHeight);
        }
        return trapWater;
    }

    public static void main(String[] args) {
        int[] a = {2,0,2};
        _42_TrappingRainWater ss = new _42_TrappingRainWater();
        System.out.println(ss.trap(a));
    }
}
