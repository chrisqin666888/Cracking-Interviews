package LeetCode.HashTable.P525_Contiguous_Array;
import java.util.*;

public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, -1);
        int counter = 0;
        int max_length = 0;

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                counter++;
            } else {
                counter--;
            }

            if (counts.containsKey(counter)) {
                max_length = Math.max(max_length, i - counts.get(counter));
            } else {
                counts.put(counter, i);
            }
        }

        return max_length;
    }
}
