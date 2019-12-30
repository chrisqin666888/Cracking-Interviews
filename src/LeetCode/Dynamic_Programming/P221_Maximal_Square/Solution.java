package LeetCode.Dynamic_Programming.P221_Maximal_Square;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix == null) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int max = 0;
        int[][] dp = new int[rows+1][cols+1];

        for(int i = 1; i < rows + 1; i++) {
            for(int j = 1; j < cols + 1; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
