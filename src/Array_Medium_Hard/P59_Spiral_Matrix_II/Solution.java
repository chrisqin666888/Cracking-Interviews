package Array_Medium_Hard.P59_Spiral_Matrix_II;

import java.util.*;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] spiral = new int[n][n];
        if(n == 0) return spiral;

        int rowBegin = 0;
        int rowEnd = n-1;
        int colBegin = 0;
        int colEnd = n-1;
        int num = 1;

        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for(int i = colBegin; i <= colEnd; i++) {
                spiral[rowBegin][i] = num++;
            }
            rowBegin++;

            // Traverse Down
            for(int i = rowBegin; i <= rowEnd; i++) {
                spiral[i][colEnd] = num++;
            }
            colEnd--;

            // Traverse Left
            for(int i = colEnd; i >= colBegin; i--) {
                spiral[rowEnd][i] = num++;
            }
            rowEnd--;

            //Traverse Up
            for(int i = rowEnd; i >= rowBegin; i--) {
                spiral[i][colBegin] = num++;
            }
            colBegin++;
        }

        return spiral;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] expected = new int[][]{{1,2,3,},{8,9,4},{7,6,5}};
        System.out.println(Arrays.deepToString(expected));
        System.out.println(Arrays.deepToString(s.generateMatrix(3)));
    }
}
