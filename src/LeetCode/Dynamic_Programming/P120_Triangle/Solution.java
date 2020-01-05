package LeetCode.Dynamic_Programming.P120_Triangle;
import java.util.*;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        int rows = triangle.size();
        int[] dp = new int[rows + 1];

        for(int i = rows - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1])+ triangle.get(i).get(j);
            }
        }

        return dp[1];
    }
}
