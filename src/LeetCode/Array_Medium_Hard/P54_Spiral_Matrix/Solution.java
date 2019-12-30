package LeetCode.Array_Medium_Hard.P54_Spiral_Matrix;
import java.util.*;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix.length == 0) return ans;

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for(int i = colBegin; i <= colEnd; i++) {
                ans.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            // Traverse Down
            for(int i = rowBegin; i <= rowEnd; i++) {
                ans.add(matrix[i][colEnd]);
            }
            colEnd--;
            // Traverse Left
            if(rowBegin <= rowEnd) {
                for(int i = colEnd; i >= colBegin; i--){
                    ans.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            // Traverse Up
            if(colBegin <= colEnd) {
                for(int i = rowEnd; i >= rowBegin; i--) {
                    ans.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }

        return ans;
    }
}
