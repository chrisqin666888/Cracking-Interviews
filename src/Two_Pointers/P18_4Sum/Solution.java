package Two_Pointers.P18_4Sum;
import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length - 3; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1; j < nums.length - 2; j++) {
                if(j != i + 1 && nums[j] == nums[j-1]) continue;

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left + 1 < right && nums[left+1] == nums[left]) {
                            left++;
                        }
                        left++;

                        while(left < right - 1 && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        right--;

                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        s.fourSum(nums, 0);
        System.out.println(s.fourSum(nums, target));
    }
}
