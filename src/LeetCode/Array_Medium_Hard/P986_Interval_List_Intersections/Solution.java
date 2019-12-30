package LeetCode.Array_Medium_Hard.P986_Interval_List_Intersections;
import java.util.*;

public class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;

        while(i < A.length && j < B.length) {
            int start1 = A[i][0];
            int end1 = A[i][1];
            int start2 = B[j][0];
            int end2 = B[j][1];

            if (end1 < start2) i++;
            if (end2 < start1) j++;

            else {
                int[] overlap = new int[2];
                overlap[0] = Math.max(start1, start2);
                overlap[1] = Math.min(end1, end2);
                res.add(overlap);
                if (end1 < end2) i++;
                else if (end1 >= end2) j++;
            }
        }

        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.intervalIntersection(A, B)));
    }
}
