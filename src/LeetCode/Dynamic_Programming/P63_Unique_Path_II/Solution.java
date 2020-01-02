package LeetCode.Dynamic_Programming.P63_Unique_Path_II;

import java.util.Arrays;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                break;
            }
            dp[i][0] = 1;
        }

        for(int j = 0; j < cols; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
                break;
            }
            dp[0][j] = 1;
        }

        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0,1,0},
                                {0,0,0,0,0},
                                {0,0,1,0,0},
                                {1,0,0,1,0},
                                {0,0,0,0,0}};

        Solution s = new Solution();
        System.out.println(s.uniquePathsWithObstacles(obstacleGrid));

    }
}
