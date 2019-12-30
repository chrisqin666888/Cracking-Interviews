package LeetCode.Binary_Search.P74_Search_A_2D_Matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        // binary search
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int pivotIdx = (left + right) / 2;
            int pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
