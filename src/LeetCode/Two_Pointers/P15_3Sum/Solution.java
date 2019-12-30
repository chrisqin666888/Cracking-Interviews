package LeetCode.Two_Pointers.P15_3Sum;
import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if(nums.length < 3) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left+1] == nums[left]) {
                        left++;
                    }
                    left++;

                    while(left < right && nums[right-1] == nums[right]) {
                        right--;
                    }
                    right--;
                }
                else if (sum > 0) {
                    right--;
                }
                else if (sum < 0){
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(s.threeSum(nums));
    }
}
