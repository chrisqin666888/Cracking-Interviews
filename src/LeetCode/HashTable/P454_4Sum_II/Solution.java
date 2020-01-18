package LeetCode.HashTable.P454_4Sum_II;
import java.util.*;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int value : C) {
            for (int i : D) {
                int sum = value + i;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res=0;
        for (int value : A) {
            for (int i : B) {
                res += map.getOrDefault(-1 * (value + i), 0);
            }
        }

        return res;
    }
}
