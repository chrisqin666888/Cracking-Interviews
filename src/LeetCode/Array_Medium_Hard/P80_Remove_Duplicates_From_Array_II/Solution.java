package LeetCode.Array_Medium_Hard.P80_Remove_Duplicates_From_Array_II;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <= 2) return nums.length;

        int lock = 2;
        for(int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[lock-2])
                nums[lock++] = nums[i];
        }
        return lock;
    }
}
