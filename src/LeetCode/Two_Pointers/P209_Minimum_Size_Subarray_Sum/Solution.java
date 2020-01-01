package LeetCode.Two_Pointers.P209_Minimum_Size_Subarray_Sum;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;

        int left = 0;
        int val_sum = 0;

        for(int i = 0; i < nums.length; i++) {
            val_sum += nums[i];

            while (val_sum >= s) {
                res = Math.min(res, i + 1 - left);
                val_sum -= nums[left];
                left++;
            }
        }

        return (res != Integer.MAX_VALUE) ? res : 0;
    }
}
