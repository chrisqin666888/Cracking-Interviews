package LeetCode.Backtracking.P90_Subsets_II;
import java.util.*;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        backTracking(res, new ArrayList<>(), new HashSet<Integer>(), nums, 0);

        return res;

    }

    private void backTracking(List<List<Integer>> res, List<Integer> tempList, HashSet<Integer> visited, int[] nums,
                              int curIndex) {
        res.add(new ArrayList<>(tempList));

        for(int i = curIndex; i < nums.length; i++) {
            if(visited.contains(i)) continue;
            if(i > 0 && nums[i] == nums[i-1] && !visited.contains(i-1)) continue;
            tempList.add(nums[i]);
            visited.add(i);
            backTracking(res, tempList, visited, nums, i+1);
            visited.remove(i);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,2};
        Solution s = new Solution();
        System.out.println(s.subsetsWithDup(input));
    }
}
