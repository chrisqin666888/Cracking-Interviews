package Array_Medium_Hard.P152_Maximum_Product_Subarray;

import java.util.Map;

public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return -1;
        int cur_max = nums[0];
        int cur_min = nums[0];
        int final_max = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int temp = cur_max;
            cur_max = Math.max(Math.max(cur_max * nums[i], cur_min * nums[i]), nums[i]);
            cur_min = Math.min(Math.min(temp * nums[i], cur_min * nums[i]), nums[i]);

            if (cur_max > final_max) {
                final_max = cur_max;
            }
        }



        return final_max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = new int[]{2,3,-2,4};
        System.out.println(s.maxProduct(input));
    }
}
