package LeetCode.Backtracking.P78_Subsets;
import java.util.*;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        backTracking(res, new ArrayList<>(), 0, nums);

        return res;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> tempList, int curIndex, int[] nums) {
        res.add(new ArrayList<>(tempList));
        for(int i = curIndex; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTracking(res, tempList, i + 1, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}
