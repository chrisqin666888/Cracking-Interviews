package LeetCode.HashTable.P947_Subarray_Sum_Divisible_by_K;
import java.util.*;

public class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int value : A) {
            sum = (sum + value) % K;
            if (sum < 0) sum += K;
            res += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }


}
