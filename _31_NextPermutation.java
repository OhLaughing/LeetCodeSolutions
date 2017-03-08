package LeetCodeSolutions;

public class _31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int next = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[next])
                break;
            else
                next = i;
        }
        //next==0说明达到了最后一个排列了
        if (next == 0) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        } else {
            int cur = next - 1;
            int index = next;
            while (index< nums.length&& nums[index] > nums[cur])
                index++;

            int tmp = nums[cur];
            nums[cur] = nums[index-1];
            nums[index-1] = tmp;

            int left = cur + 1;
            int right = nums.length-1;
            while (left < right) {
                tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3,1};
        _31_NextPermutation s = new _31_NextPermutation();
        s.nextPermutation(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
