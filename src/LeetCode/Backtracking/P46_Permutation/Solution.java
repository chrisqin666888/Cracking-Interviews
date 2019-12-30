package LeetCode.Backtracking.P46_Permutation;
import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, new ArrayList<>(), nums);

        return res;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        if(tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
        }

        for(int i = 0; i < nums.length; i++) {
            if(tempList.contains(nums[i])) {
                continue;
            } else {
                tempList.add(nums[i]);
                backTracking(res, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,2,3};
        System.out.println(s.permute(nums));
    }
}
