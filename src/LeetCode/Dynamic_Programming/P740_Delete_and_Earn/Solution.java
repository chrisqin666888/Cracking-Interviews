package LeetCode.Dynamic_Programming.P740_Delete_and_Earn;
import java.util.*;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] values = new int[n];
        for(int num: nums) {
            values[num] += num;
        }

        int take = 0, skip = 0;

        for(int i = 0; i < n; i++) {
            int take_i = skip + values[i];
            int skip_i = Math.max(skip, take);
            take = take_i;
            skip = skip_i;
        }

        return Math.max(take, skip);
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 2, 3, 3, 3, 4};
        Solution s = new Solution();
        System.out.println(s.deleteAndEarn(input));
    }
}
