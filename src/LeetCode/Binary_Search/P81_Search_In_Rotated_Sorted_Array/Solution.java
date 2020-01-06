package LeetCode.Binary_Search.P81_Search_In_Rotated_Sorted_Array;

public class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return true;

            // if left is sorted
            if (nums[start] < nums[mid]) {
                // if target is in rotated array part
                if (target < nums[start] || target > nums[mid]) {

                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[start] > nums[mid]) {
                // if right is sorted
                if(target < nums[mid] || target > nums[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                start ++;
            }
        }



        return false;
    }
}
