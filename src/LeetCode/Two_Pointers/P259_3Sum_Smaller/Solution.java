package LeetCode.Two_Pointers.P259_3Sum_Smaller;
import java.util.*;

public class Solution {
    int count;
    public int threeSumSmaller(int[] nums, int target) {
        count = 0;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;

            while (left < right) {

                if (nums[i] + nums[left] + nums[right] < target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}
