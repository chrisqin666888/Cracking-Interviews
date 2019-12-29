package Array_Medium_Hard.P31_Next_Permutation;

public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        if (i >= 0) {
            int j = n - 1;
            while (j > i && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);

    }

    private void swap(int[] nums, int lo, int hi) {
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }

    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            swap(nums, lo++, hi--);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,5,8,4,7,6,5,3,1};
        Solution solution = new Solution();
        solution.nextPermutation(input);
    }
}
