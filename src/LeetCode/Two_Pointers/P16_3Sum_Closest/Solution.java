package LeetCode.Two_Pointers.P16_3Sum_Closest;
import java.util.*;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int diff = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;

            int left = i+1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - sum) < diff) {
                    diff = Math.abs(target - sum);
                    res = sum;
                }

                if(sum == target) return sum;
                else if (sum < target) left++;
                else if (sum > target) right--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        Solution s = new Solution();
        System.out.println(s.threeSumClosest(nums, 1));
    }
}
