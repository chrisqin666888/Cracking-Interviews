package LeetCode.Greedy.P406_Queue_Reconstruction_By_Height;

import java.util.*;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // if the heights are equal, compare k-values
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> output = new ArrayList<>();
        for(int[] p : people) {
            output.add(p[1], p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }

    public static void main(String[] args) {
        int[][] input = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.reconstructQueue(input)));
    }
}
