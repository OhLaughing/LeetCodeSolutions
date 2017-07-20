package com.bigwanggang;

public class _11_containMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int mostWater = 0;
        while (left < right) {
            int theContainWater = Math.min(height[left], height[right]) * (right - left);
            if(mostWater<theContainWater)
                mostWater = theContainWater;
            if (height[left] < height[right])
                left++;
            else right--;
        }
        return mostWater;
    }

    public static void main(String[] args) {
        _11_containMostWater t = new _11_containMostWater();
        int[] a = {1, 2,4,3};
        System.out.println(t.maxArea(a));
    }
}
