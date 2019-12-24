package HashTable.P1_Two_Sum;
import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if(!map.containsKey(compliment)) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(compliment), i};
            }
        }

        return null;
    }
}
