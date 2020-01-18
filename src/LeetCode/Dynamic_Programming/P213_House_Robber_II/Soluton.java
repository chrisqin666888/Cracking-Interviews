package LeetCode.Dynamic_Programming.P213_House_Robber_II;

public class Soluton {
    public int rob(int[] nums) {
        if (nums == null)
            return 0;
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        return Math.max(robDP(nums, 0, n - 2), robDP(nums, 1, n - 1));
    }

    private int robDP(int[] nums, int first, int last) {
        int n = last - first + 1;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[first];
        int dp[] = new int[n];
        dp[0] = nums[first];
        // 注意下标
        dp[1] = Math.max(nums[first], nums[first + 1]);
        for (int i = 2; i < n; i++)
            dp[i] = Math.max(dp[i - 2] + nums[first + i], dp[i - 1]);
        return dp[n - 1];

    }
}

//if not nums:
//        return 0
//
//        if len(nums) == 1:
//        return nums[0]
//
//        pre1, cur1, pre2, cur2 = 0, 0, 0, 0
//        for i in nums[:-1]:
//        pre1, cur1 = cur1, max(pre1 + i, cur1)
//        for i in nums[1:]:
//        pre2, cur2 = cur2, max(pre2 + i, cur2)
//
//        return max(cur1, cur2)
