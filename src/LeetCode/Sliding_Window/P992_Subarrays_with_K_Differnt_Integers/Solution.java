package LeetCode.Sliding_Window.P992_Subarrays_with_K_Differnt_Integers;
import java.util.*;

 public class Solution {
    public int subarraysWithKDistinct(int[] nums, int K) {
        return atMostK(nums, K) - atMostK(nums, K - 1);
    }

    private int atMostK(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for(int j = 0; j < A.length; j++) {
            if(count.getOrDefault(A[j], 0) == 0) K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);

            while(K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) K++;
                i++;
            }

            res += j - i + 1;
        }

        return res;
    }

    public static void main(String[] args) {
         Solution solution = new Solution();
         int[] input = {1,2,1,2,3};
         System.out.println(solution.subarraysWithKDistinct(input, 2));
     }
}


