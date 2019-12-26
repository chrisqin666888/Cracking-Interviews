package Dynamic_Programming.P53_Maximum_Subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return -1;
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
